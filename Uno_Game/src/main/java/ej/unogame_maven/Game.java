package ej.unogame_maven;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game {

    private int currentPlayer;

    JuegoCPU juegoCpu;
    JButton topCardButton;

    private String[] playerIds;
    ArrayList<String> jugadores = new ArrayList<>();

    private UnoDeck deck;
    private ArrayList<ArrayList<UnoCard>> playerHand;

    private ArrayList<UnoCard> stockpile;

    private UnoCard.Color validColor;
    private UnoCard.Value validValue;

    boolean gameDirection;

    public Game(String[] pids) {

        deck = new UnoDeck();
        deck.shuffle();
        stockpile = new ArrayList<UnoCard>();

        playerIds = pids;
        currentPlayer = 0;
        gameDirection = false;

        playerHand = new ArrayList<ArrayList<UnoCard>>();

        for (int i = 0; i < pids.length; i++) {
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }

    }

    public Game(String playerName, JuegoCPU juegoCpu, JButton topCardButton) {

        this.juegoCpu = juegoCpu;
        this.topCardButton = topCardButton;

        jugadores.add(playerName);
        jugadores.add("CPU");

        deck = new UnoDeck();
        deck.shuffle();
        stockpile = new ArrayList<UnoCard>();

        playerIds = jugadores.toArray(new String[jugadores.size()]);
        currentPlayer = 0;
        gameDirection = false;

        playerHand = new ArrayList<ArrayList<UnoCard>>();

        for (int i = 0; i < playerIds.length; i++) {
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));
            playerHand.add(hand);
        }

    }

    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void instanciaCPU() {

        executor.schedule(this::ejecutarLogicaCPU, 2, TimeUnit.SECONDS);

    }

    private void ejecutarLogicaCPU() {
        logicaCPU logica = new logicaCPU(getPlayerHand(getCurrentPlayer()), this, juegoCpu);
        logica.cpuJuegaCarta(getTopCard().getColor());

        ArrayList<UnoCard> a = this.getPlayerHand("CPU");

    }

    public void start(Game game) {

        UnoCard card = deck.drawCard();
        validColor = card.getColor();
        validValue = card.getValue();

        if (card.getValue() == UnoCard.Value.Wild) {
            start(game);
        }

        if (card.getValue() == UnoCard.Value.Wild_Four || card.getValue() == UnoCard.Value.DrawTwo) {
            start(game);
        }

        if (card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel(playerIds[currentPlayer] + " fue salteado!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }

        if (card.getValue() == UnoCard.Value.Reverse) {
            JLabel message = new JLabel(" La direccion del juego ha cambiado!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            currentPlayer = playerIds.length - 1;
        }
        stockpile.add(card);
    }

    public void startCPU(Game game) {

        UnoCard card = deck.drawCard();

        validColor = card.getColor();
        validValue = card.getValue();

        if (card.getValue() == UnoCard.Value.Wild) {
            startCPU(game);
        }

        if (card.getValue() == UnoCard.Value.Wild_Four || card.getValue() == UnoCard.Value.DrawTwo) {
            startCPU(game);
        }

        if (card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel(jugadores.get(currentPlayer) + " fue salteado!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }

        if (card.getValue() == UnoCard.Value.Reverse) {
            JLabel message = new JLabel(" La direccion del juego ha cambiado!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            gameDirection ^= true;
            currentPlayer = jugadores.size() - 1;
        }

        stockpile.add(card);
    }

    public boolean isGameOver() {
        for (String player : this.playerIds) {
            if (hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    public void submitDraw(String pId) throws InvalidPlayerTurnException {

        checkPlayerTurn(pId);

        if (deck.isEmpty()) {
            deck.replaceDeckWith(stockpile);
            deck.shuffle();
        }

        getPlayerHand(pId).add(deck.drawCard());

        String a = this.getCurrentPlayer();

        //Actualiza la interfaz solo si el jugador que roba una carta es un jugador real, y no la cpu
        if (this.getCurrentPlayer() != "CPU") {

            juegoCpu.setPidName(getCurrentPlayer());
            juegoCpu.setButtonIcons();
            juegoCpu.revalidate();

        } else {
            juegoCpu.habilitadorDeButtons(true);
        }

        if (gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        } else if (gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playerIds.length - 1;
            }
        }

    }

    public void setCardColor(UnoCard.Color color) {
        validColor = color;
    }

    public void submitPlayerCard(String pId, UnoCard card, UnoCard.Color declaredColor)
            throws InvalidColorSubmissionExcpetion, InvalidValueSubmissionException, InvalidPlayerTurnException {

        checkPlayerTurn(pId);

        ArrayList<UnoCard> pHand = getPlayerHand(pId);

        if (!validCardPlay(card)) {
            if (card.getColor() == UnoCard.Color.Wild) {
                validColor = card.getColor();
                validValue = card.getValue();
            }

            if (card.getColor() != validColor) {
                JLabel message = new JLabel("Movimiento invalido, se esperaba color: " + validColor + " pero se obtuvo color " + card.getColor());
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                throw new InvalidColorSubmissionExcpetion(message, card.getColor(), validColor);
            } else if (card.getValue() != validValue) {
                JLabel message2 = new JLabel("Movimiento invalido, se esperaba valor: " + validValue + " pero se obtuvo valor " + card.getValue());
                message2.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message2);
                throw new InvalidValueSubmissionException(message2, card.getValue(), validValue);
            }
        }
        pHand.remove(card);

        juegoCpu.setPidName(getCurrentPlayer());
        juegoCpu.setButtonIcons();
        juegoCpu.habilitadorDeButtons(false);
        juegoCpu.revalidate();

        if (hasEmptyHand(this.playerIds[currentPlayer])) {
            JLabel message2 = new JLabel(this.playerIds[currentPlayer] + " gano la partida!");
            message2.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message2);
            System.exit(0);
        }

        validColor = card.getColor();
        validValue = card.getValue();
        stockpile.add(card);

        cambioDeTurno();

        if (card.getColor() == UnoCard.Color.Wild) {
            validColor = declaredColor;
        }

        if (card.getValue() == UnoCard.Value.DrawTwo) {
            var pid = playerIds[currentPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            JLabel message = new JLabel(pid + " recoge 2 cartas");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }

        if (card.getValue() == UnoCard.Value.Wild_Four) {
            var pid = playerIds[currentPlayer];
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            getPlayerHand(pid).add(deck.drawCard());
            JLabel message = new JLabel(pid + " recoge 4 cartas");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
        }

        if (card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel(playerIds[currentPlayer] + " fue salteado!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);
            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }
        if (card.getValue() == UnoCard.Value.Reverse) {
            if (playerIds.length == 2) {
                JLabel message = new JLabel("Se cambio la direccion del juego");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                if (gameDirection == false) {
                    currentPlayer = (currentPlayer + 1) % playerIds.length;
                } else if (gameDirection == true) {
                    currentPlayer = (currentPlayer - 1) % playerIds.length;
                    if (currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }
                }
            }

            gameDirection ^= true;
            if (gameDirection == true) {
                currentPlayer = (currentPlayer - 2) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
                if (currentPlayer == -2) {
                    currentPlayer = playerIds.length - 2;
                }
            } else if (gameDirection == false) {
                currentPlayer = (currentPlayer + 2) % playerIds.length;
            }

        }
    }

    public void submitCpuCard(String pId, UnoCard card, UnoCard.Color declaredColor)
            throws InvalidColorSubmissionExcpetion, InvalidValueSubmissionException, InvalidPlayerTurnException {
        {
            System.out.println("");
            System.out.println("*********************");
            System.out.println("Game.submitCpuCard()");
            System.out.println("entra con color " + declaredColor);
            System.out.println("");

            checkPlayerTurn(pId);

            ArrayList<UnoCard> cpuHand = getPlayerHand(jugadores.get(1));

            cpuHand.remove(card);

            if (hasEmptyHand(this.playerIds[currentPlayer])) {
                JLabel message2 = new JLabel(this.playerIds[currentPlayer] + " gano la partida!");
                message2.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message2);
                System.exit(0);
            }

            validColor = card.getColor();
            validValue = card.getValue();

            if (gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            } else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if (currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }

            if (card.getColor() == UnoCard.Color.Wild) {

                for (UnoCard unoCard : cpuHand) {

                    if (unoCard.getColor() == UnoCard.Color.Blue
                            || unoCard.getColor() == UnoCard.Color.Green
                            || unoCard.getColor() == UnoCard.Color.Yellow
                            || unoCard.getColor() == UnoCard.Color.Red) {

                        declaredColor = unoCard.getColor();
                        validColor = declaredColor;

                        juegoCpu.setPidName(getJugador());
                        juegoCpu.setButtonIcons();

                        System.out.println("valid color: " + validColor);
                        System.out.println("valid value: " + validValue);

                        topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + getTopCardImage()));
                        juegoCpu.revalidate();

                        System.out.println("el color elegido es " + validColor);

                        if (card.getValue() == UnoCard.Value.Wild_Four) {
                            var pid = playerIds[currentPlayer];
                            getPlayerHand(pid).add(deck.drawCard());
                            getPlayerHand(pid).add(deck.drawCard());
                            getPlayerHand(pid).add(deck.drawCard());
                            getPlayerHand(pid).add(deck.drawCard());
                            JLabel message = new JLabel(pid + " recoge 4 cartas");
                            message.setFont(new Font("Arial", Font.BOLD, 48));
                            JOptionPane.showMessageDialog(null, message);
                        }

                        break;

                    } else {
                        
                        //Si solo le quedan cartas del color Wild, elige el color rojo como predeterminado y continua con la logica
                        // hay que arreglarlo para no duplicar el codigo del WildFour

                        declaredColor = UnoCard.Color.Red;
                        validColor = declaredColor;

                        juegoCpu.setPidName(getJugador());
                        juegoCpu.setButtonIcons();

                        System.out.println("valid color: " + validColor);
                        System.out.println("valid value: " + validValue);

                        topCardButton.setIcon(new javax.swing.ImageIcon("src\\main\\resources\\cards\\" + getTopCardImage()));
                        juegoCpu.revalidate();

                        System.out.println("el color elegido es " + validColor);
                        
                        if (card.getValue() == UnoCard.Value.Wild_Four) {
                            var pid = playerIds[currentPlayer];
                            getPlayerHand(pid).add(deck.drawCard());
                            getPlayerHand(pid).add(deck.drawCard());
                            getPlayerHand(pid).add(deck.drawCard());
                            getPlayerHand(pid).add(deck.drawCard());
                            JLabel message = new JLabel(pid + " recoge 4 cartas");
                            message.setFont(new Font("Arial", Font.BOLD, 48));
                            JOptionPane.showMessageDialog(null, message);
                        }

                        break;
                    }
                }
            }

            juegoCpu.habilitadorDeButtons(true);

//            if (card.getValue() == UnoCard.Value.DrawTwo) {
//                var pid = playerIds[currentPlayer];
//                getPlayerHand(pid).add(deck.drawCard());
//                getPlayerHand(pid).add(deck.drawCard());
//                JLabel message = new JLabel(pid + " recoge 2 cartas");
//                message.setFont(new Font("Arial", Font.BOLD, 48));
//                JOptionPane.showMessageDialog(null, message);
//            }
//            if (card.getValue() == UnoCard.Value.Wild_Four) {
//                var pid = playerIds[currentPlayer];
//                getPlayerHand(pid).add(deck.drawCard());
//                getPlayerHand(pid).add(deck.drawCard());
//                getPlayerHand(pid).add(deck.drawCard());
//                getPlayerHand(pid).add(deck.drawCard());
//                JLabel message = new JLabel(pid + " recoge 4 cartas");
//                message.setFont(new Font("Arial", Font.BOLD, 48));
//                JOptionPane.showMessageDialog(null, message);
//            }
//            if (card.getValue() == UnoCard.Value.Skip) {
//                JLabel message = new JLabel(playerIds[currentPlayer] + " fue salteado!");
//                message.setFont(new Font("Arial", Font.BOLD, 48));
//                JOptionPane.showMessageDialog(null, message);
//                if (gameDirection == false) {
//                    currentPlayer = (currentPlayer + 1) % playerIds.length;
//                } else if (gameDirection == true) {
//                    currentPlayer = (currentPlayer - 1) % playerIds.length;
//                    if (currentPlayer == -1) {
//                        currentPlayer = playerIds.length - 1;
//                    }
//                }
//
//            }
//            if (card.getValue() == UnoCard.Value.Reverse) {
//                if (playerIds.length == 2) {
//                    JLabel message = new JLabel("Se cambio la direccion del juego");
//                    message.setFont(new Font("Arial", Font.BOLD, 48));
//                    JOptionPane.showMessageDialog(null, message);
//                    if (gameDirection == false) {
//                        currentPlayer = (currentPlayer + 1) % playerIds.length;
//                    } else if (gameDirection == true) {
//                        currentPlayer = (currentPlayer - 1) % playerIds.length;
//                        if (currentPlayer == -1) {
//                            currentPlayer = playerIds.length - 1;
//                        }
//                    }
//                }
//
//                gameDirection ^= true;
//                if (gameDirection == true) {
//                    currentPlayer = (currentPlayer - 2) % playerIds.length;
//                    if (currentPlayer == -1) {
//                        currentPlayer = playerIds.length - 1;
//                    }
//                    if (currentPlayer == -2) {
//                        currentPlayer = playerIds.length - 2;
//                    }
//                } else if (gameDirection == false) {
//                    currentPlayer = (currentPlayer + 2) % playerIds.length;
//                }
//            }
        }
    }

    public void cambioDeTurno() {

        //este código cambia el índice del jugador actual (currentPlayer)
        //dependiendo de la dirección del juego (gameDirection). \
        //Si gameDirection es false, avanza al siguiente jugador.
        //Si es true, retrocede al jugador anterior, asegurándose de manejar correctamente los límites del arreglo circular de jugadores.
        if (gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        } else if (gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if (currentPlayer == -1) {
                currentPlayer = playerIds.length - 1;
            }
        }
    }

    public UnoCard getTopCard() {
        return new UnoCard(validColor, validValue);
    }

    public ImageIcon getTopCardImage() {
        return new ImageIcon(validColor + "_" + validValue + ".png");
    }

    public int getCplayer() {
        return this.currentPlayer;
    }

    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }

    public String getJugador() {
        return this.jugadores.get(this.currentPlayer);
    }

    public String[] getPidsList() {
        return this.playerIds;
    }

    public String getPreviousPlayer(int i) {
        int index = this.currentPlayer - 1;
        if (index == -1) {
            index = playerIds.length - 1;
        }
        return this.playerIds[index];
    }

    public String[] getPlayers() {
        return playerIds;
    }

    public ArrayList<UnoCard> getPlayerHand(String pId) {
        int index = Arrays.asList(playerIds).indexOf(pId);
        return playerHand.get(index);
    }

    public int getPlayerHandSize(String pId) {
        return getPlayerHand(pId).size();
    }

    public UnoCard getPlayerCard(String pId, int choice) {
        ArrayList<UnoCard> hand = getPlayerHand(pId);
        return hand.get(choice);
    }

    public boolean hasEmptyHand(String pId) {
        return getPlayerHand(pId).isEmpty();
    }

    public boolean validCardPlay(UnoCard card) {
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    public void checkPlayerTurn(String pId) throws InvalidPlayerTurnException {
        if (this.playerIds[this.currentPlayer] != pId) {
            throw new InvalidPlayerTurnException("No es el turno de " + pId, pId);
        }
    }

    public ArrayList<UnoCard> getStockpile() {
        return stockpile;
    }

    public UnoDeck getDeck() {
        return deck;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    class InvalidPlayerTurnException extends Exception {

        String playerId;

        public InvalidPlayerTurnException(String message, String playerId) {
            super(message);
            this.playerId = playerId;
        }

        public String getPid() {
            return playerId;
        }
    }

    class InvalidColorSubmissionExcpetion extends Exception {

        private UnoCard.Color expected;
        private UnoCard.Color actual;

        public InvalidColorSubmissionExcpetion(JLabel message, UnoCard.Color actual, UnoCard.Color expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }

    class InvalidValueSubmissionException extends Exception {

        private UnoCard.Value expected;
        private UnoCard.Value actual;

        public InvalidValueSubmissionException(JLabel message, UnoCard.Value actual, UnoCard.Value expected) {
            this.actual = actual;
            this.expected = expected;
        }
    }
}
