import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class GUI extends JFrame{

    final private JTextArea display;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI frame = new GUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 264, 428);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(231, 188, 145));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        display = new JTextArea();
        display.setFont(new Font("Dialog", Font.BOLD, 15));
        display.setBackground(new Color(190, 227, 219));
        display.setBounds(0, 0, 248, 75);
        contentPane.add(display);

        JButton zeroButton = new JButton("");
        zeroButton.addActionListener(e -> {
            String textDisplay = display.getText().trim();
            int textLength = textDisplay.length(), operatorCounter = 0, lastOperatorIndex = 0;
            char[] textDisplayC = textDisplay.toCharArray();

            for(int i = 0; i < textLength; i++){
                if (textDisplayC[i] == '+' || textDisplayC[i] == '-' || textDisplayC[i] == '*' || textDisplayC[i] == '/' || textDisplayC[i] == '.') {
                    operatorCounter++;
                    if(textDisplayC[i] == '.')
                        operatorCounter--;
                    lastOperatorIndex = i;
                }
            }

            if(textLength == 0)
                display.setText(display.getText().trim()+"0");
            else if(textDisplayC[lastOperatorIndex] == '.')
                display.setText(display.getText().trim()+"0");
            else if(operatorCounter > 0){
                if(textDisplayC[lastOperatorIndex] == '.')
                    display.setText(display.getText().trim()+"0");
                else if(textDisplayC[textLength-1] != 0)
                    display.setText(display.getText().trim()+"0");
            }
        });
        zeroButton.setBackground(new Color(231, 188, 145));
        zeroButton.setIcon(new ImageIcon("icons/zero.png"));
        zeroButton.setBounds(70, 330, 50, 50);
        zeroButton.setFocusable(false);
        zeroButton.setBorder(null);
        contentPane.add(zeroButton);

        JButton oneButton = new JButton("");
        oneButton.addActionListener(e -> setNumberBinds("1", display.getText().trim()));
        oneButton.setBackground(new Color(231, 188, 145));
        oneButton.setIcon(new ImageIcon("icons/number-one.png"));
        oneButton.setBounds(10, 269, 50, 50);
        oneButton.setFocusable(false);
        oneButton.setBorder(null);
        contentPane.add(oneButton);

        JButton twoButton = new JButton("");
        twoButton.addActionListener(e -> setNumberBinds("2", display.getText().trim()));
        twoButton.setBackground(new Color(231, 188, 145));
        twoButton.setIcon(new ImageIcon("icons/number-2.png"));
        twoButton.setBounds(70, 269, 50, 50);
        twoButton.setFocusable(false);
        twoButton.setBorder(null);
        contentPane.add(twoButton);

        JButton threeButton = new JButton("");
        threeButton.addActionListener(e -> setNumberBinds("3", display.getText().trim()));
        threeButton.setBackground(new Color(231, 188, 145));
        threeButton.setIcon(new ImageIcon("icons/number-3.png"));
        threeButton.setBounds(130, 269, 50, 50);
        threeButton.setFocusable(false);
        threeButton.setBorder(null);
        contentPane.add(threeButton);

        JButton fourButton = new JButton("");
        fourButton.addActionListener(e -> setNumberBinds("4", display.getText().trim()));
        fourButton.setBackground(new Color(231, 188, 145));
        fourButton.setIcon(new ImageIcon("icons/number-four.png"));
        fourButton.setBounds(10, 208, 50, 50);
        fourButton.setFocusable(false);
        fourButton.setBorder(null);
        contentPane.add(fourButton);

        JButton fiveButton = new JButton("");
        fiveButton.addActionListener(e -> setNumberBinds("5", display.getText().trim()));
        fiveButton.setBackground(new Color(231, 188, 145));
        fiveButton.setIcon(new ImageIcon("icons/number-5.png"));
        fiveButton.setBounds(70, 208, 50, 50);
        fiveButton.setFocusable(false);
        fiveButton.setBorder(null);
        contentPane.add(fiveButton);

        JButton sixButton = new JButton("");
        sixButton.addActionListener(e -> setNumberBinds("6", display.getText().trim()));
        sixButton.setBackground(new Color(231, 188, 145));
        sixButton.setIcon(new ImageIcon("icons/six.png"));
        sixButton.setBounds(130, 208, 50, 50);
        sixButton.setFocusable(false);
        sixButton.setBorder(null);
        contentPane.add(sixButton);

        JButton sevenButton = new JButton("");
        sevenButton.addActionListener(e -> setNumberBinds("7", display.getText().trim()));
        sevenButton.setBackground(new Color(231, 188, 145));
        sevenButton.setIcon(new ImageIcon("icons/seven.png"));
        sevenButton.setBounds(10, 147, 50, 50);
        sevenButton.setFocusable(false);
        sevenButton.setBorder(null);
        contentPane.add(sevenButton);

        JButton eightButton = new JButton("");
        eightButton.addActionListener(e -> setNumberBinds("8", display.getText().trim()));
        eightButton.setBackground(new Color(231, 188, 145));
        eightButton.setIcon(new ImageIcon("icons/number-8.png"));
        eightButton.setBounds(70, 147, 50, 50);
        eightButton.setFocusable(false);
        eightButton.setBorder(null);
        contentPane.add(eightButton);

        JButton nineButton = new JButton("");
        nineButton.addActionListener(e -> setNumberBinds("9", display.getText().trim()));
        nineButton.setBackground(new Color(231, 188, 145));
        nineButton.setIcon(new ImageIcon("icons/number-9.png"));
        nineButton.setBounds(130, 147, 50, 50);
        nineButton.setFocusable(false);
        nineButton.setBorder(null);
        contentPane.add(nineButton);

        JButton multiplyButton = new JButton("");
        multiplyButton.addActionListener(e -> {
            String displayText = display.getText().trim();
            int textLength = displayText.length();
            if(textLength > 0) {
                char lastChar = displayText.charAt(textLength-1);
                if(lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.') {
                    display.setText(display.getText().trim()+"*");
                }
                else if(lastChar == '+' || lastChar == '-' || lastChar == '/') {
                    char[] charArray = displayText.toCharArray();
                    int textLength2 = displayText.length();
                    charArray[textLength2-1] = '*';
                    display.setText(String.valueOf(charArray));
                }
            }
        });
        multiplyButton.setBackground(new Color(231, 188, 145));
        multiplyButton.setIcon(new ImageIcon("icons/asterisk.png"));
        multiplyButton.setBounds(190, 86, 50, 50);
        multiplyButton.setFocusable(false);
        multiplyButton.setBorder(null);
        contentPane.add(multiplyButton);

        JButton divideButton = new JButton("");
        divideButton.addActionListener(e -> {
            String displayText = display.getText().trim();
            int textLength = displayText.length();
            if(textLength > 0) {
                char lastChar = displayText.charAt(textLength-1);
                if(lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.') {
                    display.setText(display.getText().trim()+"/");
                }
                else if(lastChar == '-' || lastChar == '+' || lastChar == '*') {
                    char[] charArray = displayText.toCharArray();
                    int textLength2 = displayText.length();
                    charArray[textLength2-1] = '/';
                    display.setText(String.valueOf(charArray));
                }
            }
        });
        divideButton.setBackground(new Color(231, 188, 145));
        divideButton.setIcon(new ImageIcon("icons/slash.png"));
        divideButton.setBounds(190, 147, 50, 50);
        divideButton.setFocusable(false);
        divideButton.setBorder(null);
        contentPane.add(divideButton);

        JButton plusButton = new JButton("");
        plusButton.addActionListener(e -> {
            String displayText = display.getText().trim();
            int textLength = displayText.length();
            if(textLength > 0) {
                char lastChar = displayText.charAt(textLength-1);
                if(lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.') {
                    display.setText(display.getText().trim()+"+");
                }
                else if(lastChar == '-' || lastChar == '*' || lastChar == '/') {
                    char[] charArray = displayText.toCharArray();
                    int textLength2 = displayText.length();
                    charArray[textLength2-1] = '+';
                    display.setText(String.valueOf(charArray));
                }
            }
        });
        plusButton.setBackground(new Color(231, 188, 145));
        plusButton.setIcon(new ImageIcon("icons/plus.png"));
        plusButton.setBounds(190, 208, 50, 50);
        plusButton.setFocusable(false);
        plusButton.setBorder(null);
        contentPane.add(plusButton);

        JButton minusButton = new JButton("");
        minusButton.addActionListener(e -> {
            String displayText = display.getText().trim();
            int textLength = displayText.length();
            if(textLength > 0) {
                char lastChar = displayText.charAt(textLength-1);
                if(lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.') {
                    display.setText(display.getText().trim()+"-");
                }
                else if(lastChar == '+' || lastChar == '*' || lastChar == '/') {
                    char[] charArray = displayText.toCharArray();
                    int textLength2 = displayText.length();
                    charArray[textLength2-1] = '-';
                    display.setText(String.valueOf(charArray));
                }
            }
        });
        minusButton.setBackground(new Color(231, 188, 145));
        minusButton.setIcon(new ImageIcon("icons/minus.png"));
        minusButton.setBounds(190, 269, 50, 50);
        minusButton.setFocusable(false);
        minusButton.setBorder(null);
        contentPane.add(minusButton);

        JButton equalButton = new JButton("");
        equalButton.addActionListener(e -> {
            String finalString = display.getText().trim();
            char[] finalStringC = finalString.toCharArray();
            int operatorCounter = 0, lastOperatorIndex = 0;

            for(int j = 0; j < finalString.length(); j++){
                if(finalStringC[j] == '+' || finalStringC[j] == '-' || finalStringC[j] == '/' || finalStringC[j] == '*') {
                    operatorCounter++;
                    lastOperatorIndex = j;
                }
            }

            if(finalString.length() > 0 && operatorCounter > 0 && finalString.length() > lastOperatorIndex+1) {
                char[] finalStringArray = finalString.toCharArray();
                for (int i = 0; i < finalStringArray.length; i++) {
                    if (finalStringArray[i] == '-')
                        if (finalStringArray[i - 1] == '(')
                            finalStringArray[i] = '@';
                }
                finalString = String.valueOf(finalStringArray);
                String displayResult = solvingAlgorithm.callFromGui(finalString);
                display.setText(displayResult);
            }
        });
        equalButton.setBackground(new Color(231, 188, 145));
        equalButton.setIcon(new ImageIcon("icons/equal.png"));
        equalButton.setBounds(190, 330, 50, 50);
        equalButton.setFocusable(false);
        equalButton.setBorder(null);
        contentPane.add(equalButton);

        JButton negativeButton = new JButton("");
        negativeButton.addActionListener(e -> {
            String textDisplay = display.getText().trim(), lastNumber, finalText;
            char[] textDisplayC = textDisplay.toCharArray();
            char lastChar = 0;
            int operatorNumber = 0, lastOperatorIndex = 0;

            for (int j = 0; j < textDisplay.length(); j++) {
                if (textDisplayC[j] == '+' || textDisplayC[j] == '-' || textDisplayC[j] == '*' || textDisplayC[j] == '/'  || textDisplayC[j] == ')') {
                    lastOperatorIndex = j;
                }
            }

            if(textDisplay.length() > 0)
                lastChar = textDisplayC[textDisplay.length()-1];

            for(int i = 0; i < textDisplay.length(); i++){
                if (textDisplayC[i] == '+' || textDisplayC[i] == '-' || textDisplayC[i] == '*' || textDisplayC[i] == '/') {
                    operatorNumber++;
                }
            }

            if (operatorNumber == 0 && textDisplay.length() > 0 && lastChar != '0') {
                display.setText("(-" + textDisplay + ")");
            }
            else if (operatorNumber > 0) {
                if(textDisplayC[lastOperatorIndex] != lastChar && lastChar != '0') {
                    lastNumber = textDisplay.substring(lastOperatorIndex + 1, textDisplayC.length);
                    finalText = textDisplay.substring(0, lastOperatorIndex + 1) + "(-" + lastNumber + ")";
                    display.setText(finalText);
                }
            }
            else
                display.setText("0");
        });
        negativeButton.setBackground(new Color(231, 188, 145));
        negativeButton.setIcon(new ImageIcon("icons/letter-n.png"));
        negativeButton.setBounds(130, 86, 50, 50);
        negativeButton.setFocusable(false);
        negativeButton.setBorder(null);
        contentPane.add(negativeButton);

        JButton clearButton = new JButton("");
        clearButton.addActionListener(e -> display.setText(""));
        clearButton.setBackground(new Color(231, 188, 145));
        clearButton.setIcon(new ImageIcon("icons/letter-c.png"));
        clearButton.setBounds(70, 86, 50, 50);
        clearButton.setFocusable(false);
        clearButton.setBorder(null);
        contentPane.add(clearButton);

        JButton deleteButton = new JButton("");
        deleteButton.addActionListener(e ->{
            String textDisplay = display.getText().trim();
            char[] textDisplayC = textDisplay.toCharArray();
            int lastOperatorIndex = 0;

            for(int i = 0; i < textDisplay.length()-1; i++){
                if(textDisplayC[i] == '+' || textDisplayC[i] == '-' || textDisplayC[i] == '/' || textDisplayC[i] == '*'){
                    lastOperatorIndex = i;
                }
            }

            if(textDisplay.length() == 0)
                display.setText("");
            else if(textDisplayC[textDisplay.length()-1] == ')'){
                if(lastOperatorIndex == 0){
                    textDisplay = textDisplay.substring(3, textDisplay.length()-1);
                }
                display.setText(textDisplay);
            }
            else{
                textDisplay = textDisplay.substring(0, textDisplay.length()-1);
                display.setText(textDisplay);
            }
        });
        deleteButton.setBackground(new Color(231, 188, 145));
        deleteButton.setIcon(new ImageIcon("icons/letter-d.png"));
        deleteButton.setBounds(10, 86, 50, 50);
        deleteButton.setFocusable(false);
        deleteButton.setBorder(null);
        contentPane.add(deleteButton);

        JButton pointButton = new JButton("");
        pointButton.addActionListener(e -> {
            String displayText = display.getText().trim();
            int textLength = displayText.length();
            char[] displayTextC = displayText.toCharArray();
            int lastOperatorIndex = 0;
            for(int i = 0; i < textLength; i++)
                if(displayTextC[i] == '+' || displayTextC[i] == '-' || displayTextC[i] == '/' || displayTextC[i] == '*' || displayTextC[i] == '.')
                    lastOperatorIndex = i;

            if(textLength > 0) {
                char lastChar = displayText.charAt(textLength-1);
                if(lastChar != '+' && lastChar != '-' && lastChar != '*' && lastChar != '/' && lastChar != '.' && displayTextC[lastOperatorIndex] != '.') {
                    display.setText(display.getText().trim()+".");
                }
            }
        });
        pointButton.setBackground(new Color(231, 188, 145));
        pointButton.setIcon(new ImageIcon("icons/dot.png"));
        pointButton.setBounds(10, 330, 50, 50);
        pointButton.setFocusable(false);
        pointButton.setBorder(null);
        contentPane.add(pointButton);
    }

    public void setNumberBinds(String number, String textDisplay){
        int textLength = textDisplay.length(), lastOperatorIndex = 0;
        char[] textDisplayC = textDisplay.toCharArray();

        for(int i = 0; i < textLength; i++){
            if (textDisplayC[i] == '+' || textDisplayC[i] == '-' || textDisplayC[i] == '*' || textDisplayC[i] == '/' || textDisplayC[i] == '.') {
                lastOperatorIndex = i;
            }
        }

        if (textDisplay.isEmpty() || textDisplayC[textLength - 1] == '.' || textDisplayC[lastOperatorIndex] == '.') {
            display.setText(display.getText().trim() + number);
        } else if (textDisplayC[textLength - 1] != '0')
                display.setText(display.getText().trim() + number);
    }
}