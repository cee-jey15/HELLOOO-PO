import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class YOHO extends JFrame {

    // =====================================================
    // MAIN
    // =====================================================

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);

    private final Color DARK = new Color(15, 20, 25);
    private final Color PINK = new Color(255, 105, 180);
    private final Color LIGHT_PINK = new Color(255, 220, 235);
    private final Color DEEP_PINK = new Color(205, 70, 125);
    private final Color TEXT_PINK = new Color(120, 65, 85);

    // =====================================================
    // STAGE 1
    // =====================================================

    private JTextArea terminal;
    private JProgressBar progressBar;
    private JButton surpriseButton;

    private int line = 0;
    private int character = 0;
    private Timer typingTimer;

    private final String[] messages = {
            "> BIRTHDAY HACKED!!!",
            "",
            "> Initializing birthday system...",
            "> Connecting to happiness database...",
            "> Searching for birthday person...",
            "",
            "> PERSON FOUND: MARIAN NICOLE MANGASER",
            "> Birthday verification: CONFIRMED",
            "",
            "> Checking happiness level...",
            "> WARNING: More happiness required!",
            "",
            "> Preparing something special...",
            "> Loading birthday_surprise.exe..."
    };

    // =====================================================
    // STAGE 3
    // =====================================================

    private JTextArea letterArea;
    private JButton moreButton;
    private JLabel typingStatus;

    private Timer letterTimer;
    private int letterIndex = 0;

    // =====================================================
    // STAGE 6
    // =====================================================

    private JTextArea finalTerminal;
    private JLabel finalStatus;
    private JButton replayButton;

    private Timer finalTypingTimer;

    private int finalLine = 0;
    private int finalCharacter = 0;

    private boolean finalSequenceStarted = false;

    private final String[] finalMessages = {

            "> birthday_surprise.exe",
            "",
            "> Finishing birthday protocol...",
            "",
            "> [OK] gift delivered",
            "> [OK] birthday letter delivered",
            "> [OK] secret messages unlocked",
            "> [OK] birthday wish sent",
            "",
            "> Running final check...",
            "",
            "> FINAL OBJECTIVE:",
            "> make marian nicole smile",
            "",
            "> STATUS:",
            "> hopefully successful ♡",
            "",
            "> and before this program ends...",
            "",
            "> happy birthday, nics. ♡",
            "",
            "> thank you for being one of the",
            "> unexpected good things in my life."
    };

    // =====================================================
    // EXACT LETTER
    // =====================================================

    private final String letter =

            "dear marian nicole,\n\n" +

                    "happy birthdayyy! 🎀\n\n" +

                    "i hope today reminds you kung gaano ka ka-special as a person " +
                    "and how much happiness you deserve. sana this new chapter of " +
                    "your life gives you more reasons to smile, more memories na " +
                    "pwede mong balikan, and more moments that make you genuinely happy.\n\n" +

                    "so ayunnn hehe, medyo mahirap gumawa ng program na ’to " +
                    "BWAHAHAHA, but i really wanted to give you something different po. " +
                    "something na hindi lang basta another “happy birthday” message " +
                    "na ise-send lang, but something na pinaglaanan ko talaga ng time " +
                    "and effort para maging memorable yung birthday mo. at least may " +
                    "something kang pwedeng balikan whenever you want, nikol nikol.\n\n" +

                    "one thing i appreciate about you is how you stay true to yourself. " +
                    "you're independent, funny, and amazing in your own way. ang saya " +
                    "rin na nakilala kita and that we got to share conversations and " +
                    "moments, kahit simpleng kwentuhan lang. i hope you never feel the " +
                    "need to change who you are just to impress other people. keep " +
                    "being yourself and continue doing the things that make you happy.\n\n" +

                    "sana ma-achieve mo lahat ng mga bagay na pinaghihirapan mo and " +
                    "everything you've been wishing for. and whenever life gets tiring " +
                    "or things become too much, i hope you remember na may mga taong " +
                    "naniniwala sa'yo, proud sa'yo, at laging nagwi-wish ng good things " +
                    "para sa'yo.\n\n" +

                    "enjoy your day, birthday girl! kain ka marami, smile ka marami, " +
                    "and sulitin mo yung araw na para sa'yo. sana maging masaya ka " +
                    "today and makapagpahinga ka rin from all the stress and schoolworks. " +
                    "you deserve all the happiness, peace, and good things coming your way. 💗\n\n" +

                    "happy birthday again, nics. i hope this little project makes " +
                    "your day a bit more special. ♡\n\n" +

                    "— your friend na gumugol ng maraming oras sa pagco-code para " +
                    "lang gumawa ng something special for your birthday";

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public YOHO() {

        setTitle("A Birthday Surprise for Marian Nicole Mangaser");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel.add(createTerminalScreen(), "TERMINAL");
        mainPanel.add(createGiftScreen(), "GIFT");
        mainPanel.add(createLetterScreen(), "LETTER");
        mainPanel.add(createVaultScreen(), "VAULT");
        mainPanel.add(createCakeScreen(), "CAKE");
        mainPanel.add(createFinalScreen(), "FINAL");

        add(mainPanel);

        cardLayout.show(mainPanel, "TERMINAL");

        setVisible(true);

        startTyping();
    }

    // =====================================================
    // STAGE 1 - TERMINAL
    // =====================================================

    private JPanel createTerminalScreen() {

        JPanel panel = new JPanel(new BorderLayout(10, 15));

        panel.setBackground(DARK);

        panel.setBorder(
                new EmptyBorder(30, 35, 30, 35)
        );

        JLabel title = new JLabel("HAPPYYY 18th BIRTHDAYYYYYY");

        title.setForeground(PINK);

        title.setFont(
                new Font(
                        "Monospaced",
                        Font.BOLD,
                        27
                )
        );

        panel.add(title, BorderLayout.NORTH);

        terminal = new JTextArea();

        terminal.setEditable(false);
        terminal.setFocusable(false);
        terminal.setBackground(DARK);

        terminal.setForeground(
                new Color(0, 255, 140)
        );

        terminal.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        17
                )
        );

        terminal.setLineWrap(true);
        terminal.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(terminal);

        scroll.setBorder(null);

        panel.add(scroll, BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
                new BoxLayout(
                        bottom,
                        BoxLayout.Y_AXIS
                )
        );

        progressBar = new JProgressBar(0, 100);

        progressBar.setStringPainted(true);
        progressBar.setForeground(PINK);

        progressBar.setBackground(
                new Color(40, 40, 50)
        );

        progressBar.setVisible(false);

        surpriseButton = new JButton(
                "OPEN SURPRISE  🎁"
        );

        styleButton(surpriseButton);

        surpriseButton.setVisible(false);

        surpriseButton.addActionListener(
                e -> cardLayout.show(
                        mainPanel,
                        "GIFT"
                )
        );

        bottom.add(progressBar);
        bottom.add(Box.createVerticalStrut(15));
        bottom.add(surpriseButton);

        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private void startTyping() {

        if (typingTimer != null) {
            typingTimer.stop();
        }

        typingTimer = new Timer(
                30,
                e -> {

                    if (line >= messages.length) {

                        typingTimer.stop();
                        startLoading();

                        return;
                    }

                    String current = messages[line];

                    if (character < current.length()) {

                        terminal.append(
                                String.valueOf(
                                        current.charAt(character)
                                )
                        );

                        character++;

                    } else {

                        terminal.append("\n");

                        line++;
                        character = 0;
                    }

                    terminal.setCaretPosition(
                            terminal
                                    .getDocument()
                                    .getLength()
                    );
                }
        );

        typingTimer.start();
    }

    private void startLoading() {

        progressBar.setVisible(true);

        Timer loadingTimer = new Timer(25, null);

        loadingTimer.addActionListener(
                e -> {

                    int value = progressBar.getValue();

                    if (value < 100) {

                        progressBar.setValue(value + 1);

                    } else {

                        loadingTimer.stop();

                        terminal.append(
                                "\n> SURPRISE READY!\n"
                        );

                        terminal.append(
                                "> Click OPEN SURPRISE to continue.\n"
                        );

                        surpriseButton.setVisible(true);

                        revalidate();
                        repaint();
                    }
                }
        );

        loadingTimer.start();
    }

    // =====================================================
    // STAGE 2 - GIFT
    // =====================================================

    private JPanel createGiftScreen() {

        GiftPanel panel = new GiftPanel();

        panel.setLayout(null);

        JLabel smallTitle = new JLabel(
                "a little something for you ♡",
                SwingConstants.CENTER
        );

        smallTitle.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        20
                )
        );

        smallTitle.setForeground(DEEP_PINK);

        smallTitle.setBounds(
                250,
                60,
                450,
                40
        );

        JLabel message = new JLabel(
                "I have a surprise for you...",
                SwingConstants.CENTER
        );

        message.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        32
                )
        );

        message.setForeground(TEXT_PINK);

        message.setBounds(
                150,
                105,
                650,
                50
        );

        JLabel instruction = new JLabel(
                "psst... click the gift",
                SwingConstants.CENTER
        );

        instruction.setFont(
                new Font(
                        "SansSerif",
                        Font.ITALIC,
                        17
                )
        );

        instruction.setForeground(DEEP_PINK);

        instruction.setBounds(
                300,
                165,
                350,
                30
        );

        JButton gift = new JButton("🎁");

        gift.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        100
                )
        );

        gift.setBounds(
                365,
                220,
                220,
                190
        );

        gift.setContentAreaFilled(false);
        gift.setBorderPainted(false);
        gift.setFocusPainted(false);

        gift.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        JLabel bottom = new JLabel(
                "made especially for Marian Nicole Mangaser",
                SwingConstants.CENTER
        );

        bottom.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        16
                )
        );

        bottom.setForeground(
                new Color(150, 90, 115)
        );

        bottom.setBounds(
                250,
                500,
                450,
                30
        );

        panel.add(smallTitle);
        panel.add(message);
        panel.add(instruction);
        panel.add(gift);
        panel.add(bottom);

        final int originalY = 220;
        final double[] angle = {0};

        Timer bounceTimer = new Timer(
                30,
                e -> {

                    angle[0] += 0.10;

                    int movement =
                            (int) (
                                    Math.sin(angle[0]) * 8
                            );

                    gift.setLocation(
                            gift.getX(),
                            originalY + movement
                    );
                }
        );

        bounceTimer.start();

        gift.addActionListener(
                e -> {

                    bounceTimer.stop();

                    panel.openGift();

                    gift.setVisible(false);
                    instruction.setVisible(false);
                    smallTitle.setVisible(false);
                    message.setVisible(false);
                    bottom.setVisible(false);
                }
        );

        return panel;
    }

    class GiftPanel extends JPanel {

        private final ArrayList<Confetti> confetti =
                new ArrayList<>();

        private final Random random =
                new Random();

        private boolean opened = false;

        private final Rectangle continueButton =
                new Rectangle(
                        365,
                        470,
                        220,
                        52
                );

        GiftPanel() {

            setBackground(LIGHT_PINK);

            Timer animation = new Timer(
                    30,
                    e -> {

                        if (opened) {
                            updateConfetti();
                        }

                        repaint();
                    }
            );

            animation.start();

            addMouseMotionListener(
                    new MouseMotionAdapter() {

                        @Override
                        public void mouseMoved(
                                MouseEvent e
                        ) {

                            if (
                                    opened &&
                                            continueButton.contains(
                                                    e.getPoint()
                                            )
                            ) {

                                setCursor(
                                        new Cursor(
                                                Cursor.HAND_CURSOR
                                        )
                                );

                            } else {

                                setCursor(
                                        Cursor.getDefaultCursor()
                                );
                            }
                        }
                    }
            );

            addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseClicked(
                                MouseEvent e
                        ) {

                            if (
                                    opened &&
                                            continueButton.contains(
                                                    e.getPoint()
                                            )
                            ) {

                                cardLayout.show(
                                        mainPanel,
                                        "LETTER"
                                );

                                startLetter();
                            }
                        }
                    }
            );
        }

        public void openGift() {

            opened = true;

            confetti.clear();

            for (int i = 0; i < 150; i++) {

                confetti.add(
                        new Confetti(
                                random.nextInt(950),
                                random.nextInt(300) - 300,
                                random.nextInt(5) + 2,
                                randomColor(),
                                random.nextInt(9) + 5
                        )
                );
            }

            repaint();
        }

        private void updateConfetti() {

            for (Confetti c : confetti) {

                c.y += c.speed;

                c.x +=
                        Math.sin(
                                c.y * 0.05
                        );

                if (c.y > getHeight()) {

                    c.y =
                            -random.nextInt(250);

                    c.x =
                            random.nextInt(
                                    Math.max(
                                            getWidth(),
                                            1
                                    )
                            );
                }
            }
        }

        private Color randomColor() {

            Color[] colors = {

                    PINK,

                    new Color(
                            255,
                            170,
                            200
                    ),

                    new Color(
                            255,
                            215,
                            100
                    ),

                    new Color(
                            200,
                            120,
                            255
                    ),

                    Color.WHITE
            };

            return colors[
                    random.nextInt(
                            colors.length
                    )
                    ];
        }

        @Override
        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setFont(
                    new Font(
                            "Serif",
                            Font.PLAIN,
                            40
                    )
            );

            g2.setColor(
                    new Color(
                            255,
                            120,
                            175,
                            100
                    )
            );

            g2.drawString("♡", 100, 180);
            g2.drawString("♡", 800, 160);
            g2.drawString("♡", 170, 500);
            g2.drawString("♡", 820, 470);

            if (opened) {

                for (Confetti c : confetti) {

                    g2.setColor(c.color);

                    g2.fillRoundRect(
                            (int) c.x,
                            (int) c.y,
                            c.size,
                            c.size + 4,
                            4,
                            4
                    );
                }

                g2.setColor(DEEP_PINK);

                g2.setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                48
                        )
                );

                drawCentered(
                        g2,
                        "HAPPY BIRTHDAY",
                        250
                );

                g2.setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                55
                        )
                );

                drawCentered(
                        g2,
                        "MARIAN NICOLE!",
                        320
                );

                g2.setColor(TEXT_PINK);

                g2.setFont(
                        new Font(
                                "SansSerif",
                                Font.PLAIN,
                                21
                        )
                );

                drawCentered(
                        g2,
                        "Today is your day ♡",
                        375
                );

                drawCentered(
                        g2,
                        "and this little surprise is just getting started...",
                        410
                );

                g2.setColor(PINK);

                g2.fillRoundRect(
                        continueButton.x,
                        continueButton.y,
                        continueButton.width,
                        continueButton.height,
                        25,
                        25
                );

                g2.setColor(Color.WHITE);

                g2.setFont(
                        new Font(
                                "SansSerif",
                                Font.BOLD,
                                17
                        )
                );

                drawButtonText(
                        g2,
                        "CONTINUE  →",
                        continueButton
                );
            }

            g2.dispose();
        }
    }

    // =====================================================
    // STAGE 3 - LETTER
    // =====================================================

    private JPanel createLetterScreen() {

        JPanel background =
                new JPanel(
                        new BorderLayout()
                );

        background.setBackground(
                new Color(
                        255,
                        224,
                        236
                )
        );

        background.setBorder(
                new EmptyBorder(
                        25,
                        70,
                        25,
                        70
                )
        );

        JPanel header = new JPanel();

        header.setOpaque(false);

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel heart = new JLabel(
                "♡",
                SwingConstants.CENTER
        );

        heart.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        36
                )
        );

        heart.setForeground(PINK);

        heart.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel title = new JLabel(
                "A LETTER FOR YOU",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(DEEP_PINK);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitle = new JLabel(
                "for Marian Nicole ♡",
                SwingConstants.CENTER
        );

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.ITALIC,
                        15
                )
        );

        subtitle.setForeground(TEXT_PINK);

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        header.add(heart);
        header.add(title);
        header.add(Box.createVerticalStrut(4));
        header.add(subtitle);
        header.add(Box.createVerticalStrut(12));

        background.add(
                header,
                BorderLayout.NORTH
        );

        JPanel paper =
                new JPanel(
                        new BorderLayout()
                );

        paper.setBackground(
                new Color(
                        255,
                        250,
                        252
                )
        );

        paper.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(
                                        255,
                                        185,
                                        210
                                ),
                                2
                        ),

                        new EmptyBorder(
                                25,
                                35,
                                25,
                                35
                        )
                )
        );

        letterArea = new JTextArea();

        letterArea.setEditable(false);
        letterArea.setFocusable(false);
        letterArea.setOpaque(false);
        letterArea.setLineWrap(true);
        letterArea.setWrapStyleWord(true);

        letterArea.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        18
                )
        );

        letterArea.setForeground(
                new Color(
                        95,
                        60,
                        75
                )
        );

        JScrollPane scroll =
                new JScrollPane(letterArea);

        scroll.setBorder(null);
        scroll.setOpaque(false);

        scroll.getViewport()
                .setOpaque(false);

        scroll.getVerticalScrollBar()
                .setUnitIncrement(12);

        paper.add(
                scroll,
                BorderLayout.CENTER
        );

        background.add(
                paper,
                BorderLayout.CENTER
        );

        JPanel bottom = new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
                new BoxLayout(
                        bottom,
                        BoxLayout.Y_AXIS
                )
        );

        typingStatus = new JLabel(
                "typing...",
                SwingConstants.CENTER
        );

        typingStatus.setFont(
                new Font(
                        "SansSerif",
                        Font.ITALIC,
                        13
                )
        );

        typingStatus.setForeground(
                new Color(
                        170,
                        100,
                        130
                )
        );

        typingStatus.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        moreButton = new JButton(
                "THERE'S MORE  →"
        );

        styleButton(moreButton);

        moreButton.setVisible(false);

        moreButton.addActionListener(
                e -> cardLayout.show(
                        mainPanel,
                        "VAULT"
                )
        );

        bottom.add(
                Box.createVerticalStrut(12)
        );

        bottom.add(typingStatus);

        bottom.add(
                Box.createVerticalStrut(8)
        );

        bottom.add(moreButton);

        background.add(
                bottom,
                BorderLayout.SOUTH
        );

        return background;
    }

    private void startLetter() {

        if (
                letterTimer != null &&
                        letterTimer.isRunning()
        ) {
            return;
        }

        letterArea.setText("");

        letterIndex = 0;

        moreButton.setVisible(false);

        typingStatus.setText(
                "typing... ♡"
        );

        letterTimer = new Timer(
                22,
                null
        );

        letterTimer.addActionListener(
                e -> {

                    if (
                            letterIndex >=
                                    letter.length()
                    ) {

                        letterTimer.stop();

                        typingStatus.setText(
                                "made with a little code and a lot of thought ♡"
                        );

                        moreButton.setVisible(true);

                        revalidate();
                        repaint();

                        return;
                    }

                    char current =
                            letter.charAt(
                                    letterIndex
                            );

                    letterArea.append(
                            String.valueOf(
                                    current
                            )
                    );

                    letterIndex++;

                    letterArea.setCaretPosition(
                            letterArea
                                    .getDocument()
                                    .getLength()
                    );

                    String typed =
                            letter.substring(
                                    0,
                                    letterIndex
                            );

                    if (
                            typed.endsWith(
                                    "and since it’s your day, i’ll admit one tiny thing...\n\n"
                            )
                    ) {

                        pauseLetter(1800);

                    } else if (
                            typed.endsWith(
                                    "your smile is kinda unfair.\n\n"
                            )
                    ) {

                        pauseLetter(1800);

                    } else if (
                            typed.endsWith(
                                    "and maybe there’s one person cheering just a little louder than the others. 🤭 hehe\n\n"
                            )
                    ) {

                        pauseLetter(1600);
                    }
                }
        );

        letterTimer.start();
    }

    private void pauseLetter(
            int milliseconds
    ) {

        letterTimer.stop();

        typingStatus.setText("...");

        Timer pause =
                new Timer(
                        milliseconds,
                        e -> {

                            ((Timer)
                                    e.getSource())
                                    .stop();

                            typingStatus.setText(
                                    "typing... ♡"
                            );

                            letterTimer.start();
                        }
                );

        pause.setRepeats(false);
        pause.start();
    }

    // =====================================================
    // STAGE 4 - VAULT
    // =====================================================

    private JPanel createVaultScreen() {

        JPanel background =
                new JPanel(
                        new BorderLayout()
                );

        background.setBackground(
                new Color(
                        255,
                        225,
                        238
                )
        );

        background.setBorder(
                new EmptyBorder(
                        25,
                        45,
                        25,
                        45
                )
        );

        JPanel header = new JPanel();

        header.setOpaque(false);

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel heart = new JLabel(
                "♡",
                SwingConstants.CENTER
        );

        heart.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        32
                )
        );

        heart.setForeground(PINK);

        heart.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel title = new JLabel(
                "MARIAN'S BIRTHDAY VAULT",
                SwingConstants.CENTER
        );

        title.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        title.setForeground(DEEP_PINK);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitle = new JLabel(
                "apparently one letter wasn't enough...",
                SwingConstants.CENTER
        );

        subtitle.setFont(
                new Font(
                        "SansSerif",
                        Font.ITALIC,
                        15
                )
        );

        subtitle.setForeground(TEXT_PINK);

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        header.add(heart);
        header.add(title);
        header.add(Box.createVerticalStrut(4));
        header.add(subtitle);
        header.add(Box.createVerticalStrut(15));

        background.add(
                header,
                BorderLayout.NORTH
        );

        JPanel cardGrid =
                new JPanel(
                        new GridLayout(
                                2,
                                2,
                                18,
                                18
                        )
                );

        cardGrid.setOpaque(false);


        VaultCard card1 =
                new VaultCard(
                        "01",

                        "A LITTLE APPRECIATION",

                        "you have this way of making yourself noticeable without even trying. " +
                                "siguro it's your smile, your laugh, or simply the way you are. " +
                                "kahit pagod ka na sa personal problems mo and schoolworks, you still " +
                                "try to enjoy the little moments and bring good energy sa mga taong " +
                                "nasa paligid mo.♡"
                );

        VaultCard card2 =
                new VaultCard(
                        "02",

                        "THE STORY BEHIND THIS PROGRAM",

                        "ayunnn, may pa-special project si koyah WHAHAHAHA. first time kong " +
                                "gumawa ng ganitong eme eme na work, pero naisipan kong gumawa ng " +
                                "something unique for your birthday instead of a simple message na " +
                                "ise-send lang. hehe. sana kahit papaano, napangiti kita habang " +
                                "pinipindot mo 'yan."
                );

        VaultCard card3 =
                new VaultCard(
                        "03",

                        "MY BIRTHDAY WISH FOR YOU",

                        "my wish for you is simple: i hope you become genuinely happy with " +
                                "wherever life takes you. i hope you achieve all the things you’ve " +
                                "been working so hard for and continue becoming the person you’ve " +
                                "always wanted to be. and most of all, i hope you win all the silent " +
                                "battles you don’t always talk about.♡"
                );

        VaultCard card4 =
                new VaultCard(
                        "04",

                        "A LITTLE CODING ACHIEVEMENT",

                        "if this program managed to make you smile even just once, then " +
                                "every error, every missing semicolon, and every minute i spent " +
                                "making this was worth it. ay wow, panis! full english si koyah " +
                                "BWAHAHAHAHAHA. ♡"
                );

        card1.unlock();
        card2.lock();
        card3.lock();
        card4.lock();

        cardGrid.add(card1);
        cardGrid.add(card2);
        cardGrid.add(card3);
        cardGrid.add(card4);

        background.add(
                cardGrid,
                BorderLayout.CENTER
        );

        JPanel bottom = new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
                new BoxLayout(
                        bottom,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel progress = new JLabel(
                "open message 01 to begin ♡",
                SwingConstants.CENTER
        );

        progress.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        progress.setForeground(TEXT_PINK);

        progress.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        JButton finalButton =
                new JButton(
                        "UNLOCK FINAL SURPRISE  →"
                );

        styleButton(finalButton);

        finalButton.setVisible(false);

        finalButton.addActionListener(
                e -> cardLayout.show(
                        mainPanel,
                        "CAKE"
                )
        );

        bottom.add(
                Box.createVerticalStrut(15)
        );

        bottom.add(progress);

        bottom.add(
                Box.createVerticalStrut(8)
        );

        bottom.add(finalButton);

        background.add(
                bottom,
                BorderLayout.SOUTH
        );

        card1.setOnOpened(
                () -> {

                    card2.unlock();

                    progress.setText(
                            "message 02 unlocked ♡"
                    );
                }
        );

        card2.setOnOpened(
                () -> {

                    card3.unlock();

                    progress.setText(
                            "message 03 unlocked ♡"
                    );
                }
        );

        card3.setOnOpened(
                () -> {

                    card4.unlock();

                    progress.setText(
                            "final message unlocked ♡"
                    );
                }
        );

        card4.setOnOpened(
                () -> {

                    progress.setText(
                            "ALL MESSAGES UNLOCKED ♡"
                    );

                    finalButton.setVisible(true);

                    bottom.revalidate();
                    bottom.repaint();
                }
        );

        return background;
    }

    class VaultCard extends JPanel {

        private final String title;
        private final String message;

        private final JLabel statusLabel;
        private final JButton openButton;

        private boolean locked = true;
        private boolean opened = false;

        private Runnable onOpened;

        VaultCard(
                String number,
                String title,
                String message
        ) {

            this.title = title;
            this.message = message;

            setLayout(
                    new BorderLayout(
                            10,
                            10
                    )
            );

            setBackground(
                    new Color(
                            255,
                            250,
                            252
                    )
            );

            setBorder(
                    BorderFactory.createCompoundBorder(

                            BorderFactory.createLineBorder(
                                    new Color(
                                            255,
                                            170,
                                            205
                                    ),
                                    2
                            ),

                            new EmptyBorder(
                                    18,
                                    20,
                                    18,
                                    20
                            )
                    )
            );

            JLabel numberLabel =
                    new JLabel(number);

            numberLabel.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            14
                    )
            );

            numberLabel.setForeground(PINK);

            JLabel titleLabel =
                    new JLabel(
                            "<html><center>"
                                    + title
                                    + "</center></html>",
                            SwingConstants.CENTER
                    );

            titleLabel.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            16
                    )
            );

            titleLabel.setForeground(DEEP_PINK);

            statusLabel =
                    new JLabel(
                            "LOCKED",
                            SwingConstants.CENTER
                    );

            statusLabel.setFont(
                    new Font(
                            "SansSerif",
                            Font.ITALIC,
                            13
                    )
            );

            statusLabel.setForeground(TEXT_PINK);

            openButton =
                    new JButton("LOCKED");

            openButton.setFocusPainted(false);

            openButton.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            13
                    )
            );

            openButton.setCursor(
                    new Cursor(
                            Cursor.HAND_CURSOR
                    )
            );

            openButton.addActionListener(
                    e -> openCard()
            );

            JPanel center = new JPanel();

            center.setOpaque(false);

            center.setLayout(
                    new BoxLayout(
                            center,
                            BoxLayout.Y_AXIS
                    )
            );

            titleLabel.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            statusLabel.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            openButton.setAlignmentX(
                    Component.CENTER_ALIGNMENT
            );

            center.add(titleLabel);

            center.add(
                    Box.createVerticalStrut(12)
            );

            center.add(statusLabel);

            center.add(
                    Box.createVerticalStrut(12)
            );

            center.add(openButton);

            add(
                    numberLabel,
                    BorderLayout.NORTH
            );

            add(
                    center,
                    BorderLayout.CENTER
            );
        }

        public void lock() {

            locked = true;

            openButton.setEnabled(false);

            openButton.setText("LOCKED");

            statusLabel.setText(
                    "finish the previous message first"
            );
        }

        public void unlock() {

            locked = false;

            openButton.setEnabled(true);

            openButton.setText("OPEN  ♡");

            statusLabel.setText("UNLOCKED");

            openButton.setBackground(PINK);
        }

        private void openCard() {

            if (locked) {
                return;
            }

            boolean firstOpen = !opened;
            opened = true;

            JDialog dialog =
                    new JDialog(
                            YOHO.this,
                            title,
                            true
                    );

            dialog.setSize(
                    570,
                    330
            );

            dialog.setLocationRelativeTo(
                    YOHO.this
            );

            dialog.setResizable(false);

            JPanel panel =
                    new JPanel(
                            new BorderLayout(
                                    15,
                                    15
                            )
                    );

            panel.setBackground(
                    new Color(
                            255,
                            235,
                            244
                    )
            );

            panel.setBorder(
                    new EmptyBorder(
                            30,
                            35,
                            25,
                            35
                    )
            );

            JLabel heart =
                    new JLabel(
                            "♡",
                            SwingConstants.CENTER
                    );

            heart.setFont(
                    new Font(
                            "Serif",
                            Font.BOLD,
                            38
                    )
            );

            heart.setForeground(PINK);

            JTextArea text =
                    new JTextArea(message);

            text.setEditable(false);
            text.setFocusable(false);
            text.setLineWrap(true);
            text.setWrapStyleWord(true);
            text.setOpaque(false);

            text.setFont(
                    new Font(
                            "Serif",
                            Font.PLAIN,
                            19
                    )
            );

            text.setForeground(TEXT_PINK);

            JButton close =
                    new JButton(
                            "KEEP THIS MESSAGE  ♡"
                    );

            styleButton(close);

            close.addActionListener(
                    e -> dialog.dispose()
            );

            panel.add(
                    heart,
                    BorderLayout.NORTH
            );

            panel.add(
                    text,
                    BorderLayout.CENTER
            );

            panel.add(
                    close,
                    BorderLayout.SOUTH
            );

            dialog.add(panel);

            dialog.setVisible(true);

            openButton.setEnabled(true);

            openButton.setText(
                    "OPEN AGAIN  ♡"
            );

            statusLabel.setText(
                    "message received ♡"
            );

            if (firstOpen && onOpened != null) {
                onOpened.run();
            }
        }

        public void setOnOpened(
                Runnable action
        ) {

            this.onOpened = action;
        }
    }

    // =====================================================
    // STAGE 5 - FLOWERS + CAKE
    // =====================================================

    private JPanel createCakeScreen() {

        CakePanel cakePanel =
                new CakePanel();

        cakePanel.setLayout(null);

        JLabel smallTitle =
                new JLabel(
                        "♡  ONE LAST SURPRISE  ♡",
                        SwingConstants.CENTER
                );

        smallTitle.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        20
                )
        );

        smallTitle.setForeground(DEEP_PINK);

        smallTitle.setBounds(
                250,
                25,
                450,
                35
        );

        JLabel title =
                new JLabel(
                        "for you, Marian Nicole Mangaser",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        34
                )
        );

        title.setForeground(
                new Color(
                        155,
                        60,
                        105
                )
        );

        title.setBounds(
                200,
                60,
                550,
                50
        );

        JLabel wish =
                new JLabel(
                        "make a wish...",
                        SwingConstants.CENTER
                );

        wish.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        21
                )
        );

        wish.setForeground(TEXT_PINK);

        wish.setBounds(
                300,
                420,
                350,
                40
        );

        JButton blowButton =
                new JButton(
                        "BLOW THE CANDLES  ♡"
                );

        styleButton(blowButton);

        blowButton.setBounds(
                340,
                470,
                270,
                50
        );

        JLabel afterWish =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        afterWish.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        18
                )
        );

        afterWish.setForeground(DEEP_PINK);

        afterWish.setBounds(
                150,
                440,
                650,
                40
        );

        JButton lastButton =
                new JButton(
                        "ONE LAST THING...  →"
                );

        styleButton(lastButton);

        lastButton.setBounds(
                350,
                505,
                250,
                48
        );

        lastButton.setVisible(false);

        cakePanel.add(smallTitle);
        cakePanel.add(title);
        cakePanel.add(wish);
        cakePanel.add(blowButton);
        cakePanel.add(afterWish);
        cakePanel.add(lastButton);

        blowButton.addActionListener(
                e -> {

                    cakePanel.blowCandles();

                    blowButton.setVisible(false);

                    wish.setText(
                            "wish sent ♡"
                    );

                    Timer reveal =
                            new Timer(
                                    1200,
                                    event -> {

                                        ((Timer)
                                                event.getSource())
                                                .stop();

                                        wish.setVisible(false);

                                        afterWish.setText(
                                                "i hope that whatever you wished for finds its way to you. ♡"
                                        );

                                        lastButton.setVisible(true);
                                    }
                            );

                    reveal.setRepeats(false);
                    reveal.start();
                }
        );

        lastButton.addActionListener(
                e -> {

                    cardLayout.show(
                            mainPanel,
                            "FINAL"
                    );

                    startFinalSequence();
                }
        );

        return cakePanel;
    }

    class CakePanel extends JPanel {

        private boolean candlesLit = true;
        private double flowerAngle = 0;

        private final ArrayList<Petal> petals =
                new ArrayList<>();

        private final Random random =
                new Random();

        CakePanel() {

            setBackground(
                    new Color(
                            255,
                            230,
                            240
                    )
            );

            for (int i = 0; i < 35; i++) {

                petals.add(
                        new Petal(
                                random.nextInt(950),
                                random.nextInt(650),
                                random.nextInt(2) + 1,
                                random.nextInt(8) + 5
                        )
                );
            }

            Timer animation =
                    new Timer(
                            40,
                            e -> {

                                flowerAngle += 0.04;

                                updatePetals();

                                repaint();
                            }
                    );

            animation.start();
        }

        public void blowCandles() {

            candlesLit = false;

            for (int i = 0; i < 50; i++) {

                petals.add(
                        new Petal(
                                random.nextInt(950),
                                -random.nextInt(300),
                                random.nextInt(3) + 1,
                                random.nextInt(9) + 5
                        )
                );
            }

            repaint();
        }

        private void updatePetals() {

            for (Petal petal : petals) {

                petal.y += petal.speed;

                petal.x +=
                        Math.sin(
                                petal.y * 0.025
                        ) * 0.8;

                if (
                        petal.y >
                                getHeight()
                ) {

                    petal.y =
                            -random.nextInt(100);

                    petal.x =
                            random.nextInt(
                                    Math.max(
                                            getWidth(),
                                            1
                                    )
                            );
                }
            }
        }

        @Override
        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Background circles

            g2.setColor(
                    new Color(
                            255,
                            255,
                            255,
                            100
                    )
            );

            g2.fillOval(
                    50,
                    70,
                    170,
                    170
            );

            g2.fillOval(
                    740,
                    70,
                    160,
                    160
            );

            g2.fillOval(
                    720,
                    400,
                    210,
                    210
            );

            g2.fillOval(
                    20,
                    420,
                    180,
                    180
            );

            // Falling petals

            for (Petal petal : petals) {

                g2.setColor(
                        new Color(
                                255,
                                150,
                                190,
                                130
                        )
                );

                g2.fillOval(
                        (int) petal.x,
                        (int) petal.y,
                        petal.size,
                        petal.size + 4
                );
            }

            double sway =
                    Math.sin(
                            flowerAngle
                    ) * 5;

            // Left flowers

            drawFlower(
                    g2,
                    100 + (int) sway,
                    330,
                    28,
                    new Color(
                            255,
                            120,
                            175
                    )
            );

            drawFlower(
                    g2,
                    165 - (int) sway,
                    400,
                    23,
                    new Color(
                            235,
                            140,
                            210
                    )
            );

            drawFlower(
                    g2,
                    75 - (int) sway,
                    470,
                    20,
                    new Color(
                            255,
                            185,
                            210
                    )
            );

            // Right flowers

            drawFlower(
                    g2,
                    850 - (int) sway,
                    330,
                    28,
                    new Color(
                            255,
                            120,
                            175
                    )
            );

            drawFlower(
                    g2,
                    785 + (int) sway,
                    400,
                    23,
                    new Color(
                            235,
                            140,
                            210
                    )
            );

            drawFlower(
                    g2,
                    875 + (int) sway,
                    470,
                    20,
                    new Color(
                            255,
                            185,
                            210
                    )
            );

            // Cake

            int cakeX = 325;

            g2.setColor(
                    new Color(
                            190,
                            100,
                            130,
                            45
                    )
            );

            g2.fillOval(
                    cakeX - 25,
                    390,
                    350,
                    35
            );

            g2.setColor(
                    new Color(
                            255,
                            170,
                            205
                    )
            );

            g2.fillRoundRect(
                    cakeX,
                    320,
                    300,
                    95,
                    30,
                    30
            );

            g2.setColor(
                    new Color(
                            255,
                            245,
                            248
                    )
            );

            g2.fillRoundRect(
                    cakeX,
                    320,
                    300,
                    35,
                    30,
                    30
            );

            g2.setColor(
                    new Color(
                            255,
                            195,
                            218
                    )
            );

            g2.fillRoundRect(
                    cakeX + 55,
                    260,
                    190,
                    75,
                    25,
                    25
            );

            g2.setColor(
                    new Color(
                            255,
                            250,
                            252
                    )
            );

            g2.fillRoundRect(
                    cakeX + 55,
                    260,
                    190,
                    28,
                    25,
                    25
            );

            // Cake text

            g2.setColor(
                    new Color(
                            175,
                            65,
                            115
                    )
            );

            g2.setFont(
                    new Font(
                            "Serif",
                            Font.BOLD,
                            23
                    )
            );

            String cakeText = "NICS ♡";

            FontMetrics cakeMetrics =
                    g2.getFontMetrics();

            g2.drawString(
                    cakeText,

                    cakeX
                            + 150
                            - cakeMetrics
                            .stringWidth(
                                    cakeText
                            ) / 2,

                    380
            );

            // Candles

            int[] candleX = {
                    410,
                    455,
                    500,
                    545
            };

            for (int x : candleX) {

                g2.setColor(
                        new Color(
                                245,
                                120,
                                170
                        )
                );

                g2.fillRoundRect(
                        x,
                        220,
                        10,
                        42,
                        5,
                        5
                );

                g2.setColor(Color.WHITE);

                g2.drawLine(
                        x + 1,
                        230,
                        x + 9,
                        237
                );

                g2.drawLine(
                        x + 1,
                        245,
                        x + 9,
                        252
                );

                if (candlesLit) {

                    int flicker =
                            random.nextInt(5);

                    g2.setColor(
                            new Color(
                                    255,
                                    185,
                                    70
                            )
                    );

                    g2.fillOval(
                            x - 2,
                            198 - flicker,
                            14,
                            24
                    );

                    g2.setColor(
                            new Color(
                                    255,
                                    235,
                                    130
                            )
                    );

                    g2.fillOval(
                            x + 2,
                            204 - flicker,
                            6,
                            14
                    );
                }
            }

            // Hearts

            g2.setColor(
                    new Color(
                            220,
                            80,
                            140,
                            100
                    )
            );

            g2.setFont(
                    new Font(
                            "Serif",
                            Font.PLAIN,
                            30
                    )
            );

            g2.drawString("♡", 230, 200);
            g2.drawString("♡", 700, 210);
            g2.drawString("♡", 260, 480);
            g2.drawString("♡", 675, 475);

            g2.dispose();
        }

        private void drawFlower(
                Graphics2D g2,
                int x,
                int y,
                int size,
                Color petalColor
        ) {

            g2.setStroke(
                    new BasicStroke(
                            4,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    )
            );

            g2.setColor(
                    new Color(
                            100,
                            175,
                            115
                    )
            );

            g2.drawLine(
                    x,
                    y,
                    x,
                    y + 90
            );

            g2.fillOval(
                    x - 25,
                    y + 40,
                    28,
                    13
            );

            g2.fillOval(
                    x,
                    y + 60,
                    28,
                    13
            );

            g2.setColor(petalColor);

            g2.fillOval(
                    x - size / 2,
                    y - size,
                    size,
                    size
            );

            g2.fillOval(
                    x - size,
                    y - size / 2,
                    size,
                    size
            );

            g2.fillOval(
                    x,
                    y - size / 2,
                    size,
                    size
            );

            g2.fillOval(
                    x - size / 2,
                    y,
                    size,
                    size
            );

            g2.setColor(
                    new Color(
                            255,
                            215,
                            100
                    )
            );

            g2.fillOval(
                    x - size / 4,
                    y - size / 4,
                    size / 2,
                    size / 2
            );
        }
    }

    // =====================================================
    // STAGE 6 - FINAL ENDING
    // =====================================================

    private JPanel createFinalScreen() {

        FinalPanel panel =
                new FinalPanel();

        panel.setLayout(
                new BorderLayout(
                        20,
                        20
                )
        );

        panel.setBorder(
                new EmptyBorder(
                        25,
                        70,
                        25,
                        70
                )
        );

        // Header

        JPanel header = new JPanel();

        header.setOpaque(false);

        header.setLayout(
                new BoxLayout(
                        header,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel heart =
                new JLabel(
                        "♡",
                        SwingConstants.CENTER
                );

        heart.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        30
                )
        );

        heart.setForeground(PINK);

        heart.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel title =
                new JLabel(
                        "BIRTHDAY PROTOCOL",
                        SwingConstants.CENTER
                );

        title.setFont(
                new Font(
                        "Monospaced",
                        Font.BOLD,
                        25
                )
        );

        title.setForeground(PINK);

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel subtitle =
                new JLabel(
                        "final sequence",
                        SwingConstants.CENTER
                );

        subtitle.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );

        subtitle.setForeground(
                new Color(
                        170,
                        170,
                        180
                )
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        header.add(heart);
        header.add(title);
        header.add(Box.createVerticalStrut(3));
        header.add(subtitle);

        panel.add(
                header,
                BorderLayout.NORTH
        );

        // Terminal

        finalTerminal = new JTextArea();

        finalTerminal.setEditable(false);
        finalTerminal.setFocusable(false);
        finalTerminal.setOpaque(false);
        finalTerminal.setLineWrap(true);
        finalTerminal.setWrapStyleWord(true);

        finalTerminal.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        16
                )
        );

        finalTerminal.setForeground(
                new Color(
                        225,
                        225,
                        230
                )
        );

        JScrollPane scroll =
                new JScrollPane(
                        finalTerminal
                );

        scroll.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                255,
                                105,
                                180,
                                80
                        ),
                        1
                )
        );

        scroll.setOpaque(false);

        scroll.getViewport()
                .setOpaque(false);

        scroll.getVerticalScrollBar()
                .setUnitIncrement(12);

        panel.add(
                scroll,
                BorderLayout.CENTER
        );

        // Bottom

        JPanel bottom = new JPanel();

        bottom.setOpaque(false);

        bottom.setLayout(
                new BoxLayout(
                        bottom,
                        BoxLayout.Y_AXIS
                )
        );

        finalStatus =
                new JLabel(
                        "completing surprise...",
                        SwingConstants.CENTER
                );

        finalStatus.setForeground(
                new Color(
                        180,
                        180,
                        190
                )
        );

        finalStatus.setFont(
                new Font(
                        "Monospaced",
                        Font.ITALIC,
                        13
                )
        );

        finalStatus.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        replayButton =
                new JButton(
                        "REPLAY SURPRISE  ↻"
                );

        styleButton(replayButton);

        replayButton.setVisible(false);

        replayButton.addActionListener(
                e -> restartSurprise()
        );

        bottom.add(finalStatus);
        bottom.add(Box.createVerticalStrut(10));
        bottom.add(replayButton);

        panel.add(
                bottom,
                BorderLayout.SOUTH
        );

        return panel;
    }

    private void startFinalSequence() {

        if (finalSequenceStarted) {
            return;
        }

        finalSequenceStarted = true;

        finalLine = 0;
        finalCharacter = 0;

        finalTerminal.setText("");

        finalStatus.setText(
                "completing surprise..."
        );

        replayButton.setVisible(false);

        finalTypingTimer =
                new Timer(
                        35,
                        null
                );

        finalTypingTimer.addActionListener(
                e -> {

                    if (
                            finalLine >=
                                    finalMessages.length
                    ) {

                        finalTypingTimer.stop();

                        finalStatus.setText(
                                "birthday_surprise.exe completed successfully ♡"
                        );

                        Timer finishDelay =
                                new Timer(
                                        1400,
                                        event -> {

                                            ((Timer)
                                                    event.getSource())
                                                    .stop();

                                            finalStatus.setText(
                                                    "thank you for opening this little surprise ♡"
                                            );

                                            replayButton.setVisible(true);

                                            revalidate();
                                            repaint();
                                        }
                                );

                        finishDelay.setRepeats(false);
                        finishDelay.start();

                        return;
                    }

                    String current =
                            finalMessages[
                                    finalLine
                                    ];

                    if (
                            finalCharacter <
                                    current.length()
                    ) {

                        finalTerminal.append(
                                String.valueOf(
                                        current.charAt(
                                                finalCharacter
                                        )
                                )
                        );

                        finalCharacter++;

                    } else {

                        finalTerminal.append("\n");

                        finalLine++;
                        finalCharacter = 0;

                        if (
                                current.equals(
                                        "> Running final check..."
                                )
                        ) {

                            pauseFinal(900);

                        } else if (
                                current.equals(
                                        "> make marian nicole smile"
                                )
                        ) {

                            pauseFinal(1100);

                        } else if (
                                current.equals(
                                        "> hopefully successful ♡"
                                )
                        ) {

                            pauseFinal(1400);

                        } else if (
                                current.equals(
                                        "> and before this program ends..."
                                )
                        ) {

                            pauseFinal(1500);

                        } else if (
                                current.equals(
                                        "> happy birthday, nics. ♡"
                                )
                        ) {

                            pauseFinal(1300);
                        }
                    }

                    finalTerminal.setCaretPosition(
                            finalTerminal
                                    .getDocument()
                                    .getLength()
                    );
                }
        );

        finalTypingTimer.start();
    }

    private void pauseFinal(
            int milliseconds
    ) {

        if (
                finalTypingTimer == null ||
                        !finalTypingTimer.isRunning()
        ) {
            return;
        }

        finalTypingTimer.stop();

        Timer pause =
                new Timer(
                        milliseconds,
                        e -> {

                            ((Timer)
                                    e.getSource())
                                    .stop();

                            if (
                                    finalTypingTimer != null
                            ) {

                                finalTypingTimer.start();
                            }
                        }
                );

        pause.setRepeats(false);
        pause.start();
    }

    // =====================================================
    // FINAL SCREEN FLOWERS
    // =====================================================

    class FinalPanel extends JPanel {

        private final ArrayList<FinalFlower> flowers =
                new ArrayList<>();

        private double animationTime = 0;

        FinalPanel() {

            setBackground(DARK);

            // Left side

            flowers.add(
                    new FinalFlower(
                            75,
                            575,
                            28,
                            0
                    )
            );

            flowers.add(
                    new FinalFlower(
                            130,
                            595,
                            22,
                            0.7
                    )
            );

            flowers.add(
                    new FinalFlower(
                            185,
                            580,
                            25,
                            1.3
                    )
            );

            // Right side

            flowers.add(
                    new FinalFlower(
                            765,
                            585,
                            25,
                            0.4
                    )
            );

            flowers.add(
                    new FinalFlower(
                            820,
                            570,
                            28,
                            1
                    )
            );

            flowers.add(
                    new FinalFlower(
                            875,
                            595,
                            22,
                            1.5
                    )
            );

            Timer animation =
                    new Timer(
                            40,
                            e -> {

                                animationTime += 0.04;

                                repaint();
                            }
                    );

            animation.start();
        }

        @Override
        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Pink glow

            g2.setColor(
                    new Color(
                            255,
                            105,
                            180,
                            15
                    )
            );

            g2.fillOval(
                    -100,
                    300,
                    450,
                    450
            );

            g2.fillOval(
                    600,
                    300,
                    450,
                    450
            );

            // Tiny stars / dots

            g2.setColor(
                    new Color(
                            255,
                            190,
                            220,
                            80
                    )
            );

            g2.fillOval(80, 120, 5, 5);
            g2.fillOval(160, 180, 4, 4);
            g2.fillOval(830, 150, 5, 5);
            g2.fillOval(760, 210, 4, 4);
            g2.fillOval(230, 100, 3, 3);
            g2.fillOval(710, 100, 3, 3);

            g2.setFont(
                    new Font(
                            "Serif",
                            Font.PLAIN,
                            28
                    )
            );

            g2.setColor(
                    new Color(
                            255,
                            130,
                            185,
                            80
                    )
            );

            g2.drawString("♡", 45, 190);
            g2.drawString("♡", 870, 200);
            g2.drawString("♡", 90, 300);
            g2.drawString("♡", 825, 315);

            // Flowers

            for (
                    FinalFlower flower :
                    flowers
            ) {

                double sway =
                        Math.sin(
                                animationTime
                                        + flower.offset
                        ) * 5;

                drawFinalFlower(
                        g2,
                        flower.x
                                + (int) sway,
                        flower.y,
                        flower.size
                );
            }

            g2.dispose();
        }

        private void drawFinalFlower(
                Graphics2D g2,
                int x,
                int y,
                int size
        ) {

            // Stem

            g2.setStroke(
                    new BasicStroke(
                            3,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND
                    )
            );

            g2.setColor(
                    new Color(
                            90,
                            150,
                            110
                    )
            );

            g2.drawLine(
                    x,
                    y,
                    x,
                    y + 80
            );

            // Leaves

            g2.fillOval(
                    x - 20,
                    y + 35,
                    22,
                    10
            );

            g2.fillOval(
                    x,
                    y + 50,
                    22,
                    10
            );

            // Pink glow

            g2.setColor(
                    new Color(
                            255,
                            105,
                            180,
                            40
                    )
            );

            g2.fillOval(
                    x - size - 7,
                    y - size - 7,
                    size * 2 + 14,
                    size * 2 + 14
            );

            // Petals

            g2.setColor(
                    new Color(
                            255,
                            125,
                            180
                    )
            );

            g2.fillOval(
                    x - size / 2,
                    y - size,
                    size,
                    size
            );

            g2.fillOval(
                    x - size,
                    y - size / 2,
                    size,
                    size
            );

            g2.fillOval(
                    x,
                    y - size / 2,
                    size,
                    size
            );

            g2.fillOval(
                    x - size / 2,
                    y,
                    size,
                    size
            );

            // Center

            g2.setColor(
                    new Color(
                            255,
                            220,
                            120
                    )
            );

            g2.fillOval(
                    x - size / 4,
                    y - size / 4,
                    size / 2,
                    size / 2
            );
        }
    }

    // =====================================================
    // RESTART
    // =====================================================

    private void restartSurprise() {

        if (
                typingTimer != null &&
                        typingTimer.isRunning()
        ) {

            typingTimer.stop();
        }

        if (
                letterTimer != null &&
                        letterTimer.isRunning()
        ) {

            letterTimer.stop();
        }

        if (
                finalTypingTimer != null &&
                        finalTypingTimer.isRunning()
        ) {

            finalTypingTimer.stop();
        }

        // Reset first screen

        line = 0;
        character = 0;

        terminal.setText("");

        progressBar.setValue(0);
        progressBar.setVisible(false);

        surpriseButton.setVisible(false);

        // Reset letter

        letterIndex = 0;

        letterArea.setText("");

        moreButton.setVisible(false);

        typingStatus.setText(
                "typing..."
        );

        // Reset final screen

        finalLine = 0;
        finalCharacter = 0;

        finalSequenceStarted = false;

        finalTerminal.setText("");

        finalStatus.setText(
                "completing surprise..."
        );

        replayButton.setVisible(false);

        // Go back to beginning

        cardLayout.show(
                mainPanel,
                "TERMINAL"
        );

        startTyping();
    }

    // =====================================================
    // OBJECTS
    // =====================================================

    static class Confetti {

        double x;
        double y;

        int speed;
        Color color;
        int size;

        Confetti(
                double x,
                double y,
                int speed,
                Color color,
                int size
        ) {

            this.x = x;
            this.y = y;
            this.speed = speed;
            this.color = color;
            this.size = size;
        }
    }

    static class Petal {

        double x;
        double y;

        int speed;
        int size;

        Petal(
                double x,
                double y,
                int speed,
                int size
        ) {

            this.x = x;
            this.y = y;
            this.speed = speed;
            this.size = size;
        }
    }

    static class FinalFlower {

        int x;
        int y;
        int size;

        double offset;

        FinalFlower(
                int x,
                int y,
                int size,
                double offset
        ) {

            this.x = x;
            this.y = y;
            this.size = size;
            this.offset = offset;
        }
    }

    // =====================================================
    // HELPERS
    // =====================================================

    private void styleButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        17
                )
        );

        button.setBackground(PINK);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);

        button.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }

    private void drawCentered(
            Graphics2D g2,
            String text,
            int y
    ) {

        FontMetrics fm =
                g2.getFontMetrics();

        int width =
                mainPanel.getWidth();

        if (width <= 0) {
            width = 950;
        }

        int x =
                (
                        width
                                - fm.stringWidth(text)
                ) / 2;

        g2.drawString(
                text,
                x,
                y
        );
    }

    private void drawButtonText(
            Graphics2D g2,
            String text,
            Rectangle rectangle
    ) {

        FontMetrics fm =
                g2.getFontMetrics();

        int x =
                rectangle.x
                        + (
                        rectangle.width
                                - fm.stringWidth(text)
                ) / 2;

        int y =
                rectangle.y
                        + (
                        rectangle.height
                                + fm.getAscent()
                                - fm.getDescent()
                ) / 2;

        g2.drawString(
                text,
                x,
                y
        );
    }

    // =====================================================
    // RUN PROGRAM
    // =====================================================

    public static void main(
            String[] args
    ) {

        SwingUtilities.invokeLater(
                YOHO::new
        );
    }
}