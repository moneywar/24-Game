import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.TextField;
import java.util.Random;

public class mainGameUI {
    private JFrame f;
    private JLabel gameName;
    private JButton buttonNum1;
    private JButton buttonNum2;
    private JButton buttonNum3;
    private JButton buttonNum4;
    private JButton operatorPlus;
    private JButton operatorMinus;
    private JButton operatorMulti;
    private JButton operatorDivine;
    private JButton reset;
    private JButton soln;
    private JButton next;
    private JButton memX;
    private JLabel text;
    private JLabel stage;
    private int stagenum = 1;
    private int n = 0;
    private double result;
    private double numA;
    private double denomA;
    private double numB;
    private double denomB;
    private double numC;
    private double denomC;
    private double numD;
    private double denomD;
    private double numX;
    private double denomX;
    private double numY;
    private double denomY;
    private double dividend;
    private double divisor;
    private boolean xIsPicked;
    private boolean opIsPicked;
    private String pickedOp;
    private ArrayList<ploblems> aList = new ArrayList<>();

    private void ploblemsList() {
        aList.add(generateProblem());
        aList.add(generateProblem());
        /*aList.add(new ploblems(4, 7, 8, 5, "8+4+5+7"));
        aList.add(new ploblems(2, 2, 5, 7, "(2*7)+(5*2)"));
        aList.add(new ploblems(6, 3, 3, 5, "(6-3)*(3+5)"));
        aList.add(new ploblems(3, 2, 5, 6, "(5-3+2)*6"));
        aList.add(new ploblems(9, 2, 8, 9, "((9/9)+2)*8"));
        aList.add(new ploblems(5, 5, 9, 9, "(5*5)-(9/9)"));
        aList.add(new ploblems(4, 7, 7, 7, "(7-(7/7))*4"));
        aList.add(new ploblems(7, 8, 8, 9, "(9-7)*8+8"));
        aList.add(new ploblems(6, 9, 7, 8, "(6*8/(9-7)"));
        aList.add(new ploblems(8, 8, 9, 13, "((13-9)*8)-8"));*/
    }

    public mainGameUI() {
        f = new JFrame("24 Game");
        f.getContentPane().setLayout(null);
        f.setBounds(550, 10, 500, 800);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        detail();
        f.setVisible(true);
        text = new JLabel("Game24");
        text.setBounds(89, 50, 315, 100);
        text.setFont(new Font("Game24", Font.PLAIN, 80));
        f.add(text);
        stage = new JLabel("Stage");
        stage.setBounds(200, 160, 200, 40);
        stage.setFont(new Font("stage", Font.PLAIN, 30));
        stage.setText("Stage "+stagenum);
        f.add(stage);
        text.setForeground(Color.BLUE);
        stage.setForeground(Color.RED);
        buttonNum1.setBackground(Color.YELLOW);
        buttonNum2.setBackground(Color.YELLOW);
        buttonNum3.setBackground(Color.YELLOW);
        buttonNum4.setBackground(Color.YELLOW);
        operatorPlus.setBackground(Color.YELLOW);
        operatorMinus.setBackground(Color.YELLOW);
        operatorMulti.setBackground(Color.YELLOW);
        operatorDivine.setBackground(Color.YELLOW);
        reset.setBackground(Color.BLUE);
        soln.setBackground(Color.BLUE);
        next.setBackground(Color.BLUE);
        reset.setForeground(Color.WHITE);
        soln.setForeground(Color.WHITE);
        next.setForeground(Color.WHITE);

    }

    private void detail() {

        // new button
        buttonNum1 = new JButton();
        buttonNum2 = new JButton();
        buttonNum3 = new JButton();
        buttonNum4 = new JButton();

        operatorPlus = new JButton("+");
        operatorMinus = new JButton("-");
        operatorMulti = new JButton("*");
        operatorDivine = new JButton("/");

        reset = new JButton("reset");
        soln = new JButton("solution");
        next = new JButton("next");

        // number button
        buttonNum1.setBounds(125, 325, 100, 100);
        buttonNum2.setBounds(buttonNum1.getX() + 150, buttonNum1.getY(), 100, 100);
        buttonNum3.setBounds(buttonNum1.getX(), buttonNum1.getY() + 150, 100, 100);
        buttonNum4.setBounds(buttonNum1.getX() + 150, buttonNum1.getY() + 150, 100, 100);

        f.add(buttonNum1);
        f.add(buttonNum2);
        f.add(buttonNum3);
        f.add(buttonNum4);

        buttonNum1.setFont(new Font("reset", Font.PLAIN, 40));
        buttonNum2.setFont(new Font("reset", Font.PLAIN, 40));
        buttonNum3.setFont(new Font("reset", Font.PLAIN, 40));
        buttonNum4.setFont(new Font("reset", Font.PLAIN, 40));

        // operrators button
        operatorPlus.setBounds(112, 625, 50, 50);
        operatorMinus.setBounds(operatorPlus.getX() + 75, operatorPlus.getY(), 50, 50);
        operatorMulti.setBounds(operatorMinus.getX() + 75, operatorPlus.getY(), 50, 50);
        operatorDivine.setBounds(operatorMulti.getX() + 75, operatorPlus.getY(), 50, 50);

        f.add(operatorPlus);
        f.add(operatorMinus);
        f.add(operatorMulti);
        f.add(operatorDivine);
        operatorPlus.setFont(new Font("reset", Font.PLAIN, 20));
        operatorMinus.setFont(new Font("reset", Font.PLAIN, 20));
        operatorMulti.setFont(new Font("reset", Font.PLAIN, 20));
        operatorDivine.setFont(new Font("reset", Font.PLAIN, 20));

        // reset roln next
        soln.setBounds(185, 225, 130, 50);
        reset.setBounds(soln.getX() - 125, soln.getY(), 100, 50);
        next.setBounds(soln.getX() + 155, soln.getY(), 100, 50);

        f.add(reset);
        reset.setFont(new Font("reset", Font.PLAIN, 20));
        f.add(soln);
        soln.setFont(new Font("soln", Font.PLAIN, 18));
        f.add(next);
        next.setFont(new Font("next", Font.PLAIN, 20));

        // action listener
        AllButtonListener b = new AllButtonListener();
        buttonNum1.addActionListener(b);
        buttonNum2.addActionListener(b);
        buttonNum3.addActionListener(b);
        buttonNum4.addActionListener(b);
        operatorPlus.addActionListener(b);
        operatorMinus.addActionListener(b);
        operatorMulti.addActionListener(b);
        operatorDivine.addActionListener(b);
        next.addActionListener(b);
        soln.addActionListener(b);
        reset.addActionListener(b);
        newGame();
    }

    private void newGame() {
        ploblemsList();

        result = 0;
        soln.setFont(new Font("soln", Font.PLAIN, 18));
        
        buttonNum1.setText(String.format("%.0f", aList.get(n).getA()));
        buttonNum2.setText(String.format("%.0f", aList.get(n).getB()));
        buttonNum3.setText(String.format("%.0f", aList.get(n).getC()));
        buttonNum4.setText(String.format("%.0f", aList.get(n).getD()));
        buttonNum1.setEnabled(true);
        buttonNum2.setEnabled(true);
        buttonNum3.setEnabled(true);
        buttonNum4.setEnabled(true);
        numA = Double.valueOf(aList.get(n).getA());
        denomA = 1;
        numB = Double.valueOf(aList.get(n).getB());
        denomB = 1;
        numC = Double.valueOf(aList.get(n).getC());
        denomC = 1;
        numD = Double.valueOf(aList.get(n).getD());
        denomD = 1;
        soln.setBackground(Color.BLUE);
        soln.setText("solution");
        play();
    }

    private void play() {
        xIsPicked = false;
        opIsPicked = false;
    }

    private ploblems generateProblem(){
        ArrayList<Integer> num = new ArrayList<>();
        String solution = "";
        Random r = new Random();
        for(int i=0;i<4;i++){
            num.add(r.nextInt(9)+1);
        }
        solution = game24.checkPossibleAndAns(num);
        if(solution.equals("")){
            return generateProblem();
        }
        System.out.println(num);
        return new ploblems(num.get(0), num.get(1), num.get(2), num.get(3), solution);
    }

    private class AllButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JButton source = (JButton) ev.getSource();
            // ใส่เงื่อนไข
            buttonNum1.setBackground(Color.YELLOW);
            buttonNum2.setBackground(Color.YELLOW);
            buttonNum3.setBackground(Color.YELLOW);
            buttonNum4.setBackground(Color.YELLOW);
            if ((source == buttonNum1 || source == buttonNum2 || source == buttonNum3 || source == buttonNum4)
                    && (!opIsPicked)) {
                memX = source;
                if (source == buttonNum1) {
                    numX = numA;
                    denomX = denomA;
                } else if (source == buttonNum2) {
                    numX = numB;
                    denomX = denomB;
                } else if (source == buttonNum3) {
                    numX = numC;
                    denomX = denomC;
                } else if (source == buttonNum4) {
                    numX = numD;
                    denomX = denomD;
                }
                source.setBackground(Color.ORANGE);
                System.out.println("numX = " + numX);
                System.out.println("denomX = " + denomX);
                System.out.println("memo " + memX.getText());
                xIsPicked = true;

            } else if ((source == operatorPlus || source == operatorMinus || source == operatorMulti
                    || source == operatorDivine) && xIsPicked) {

                operatorPlus.setBackground(Color.YELLOW);
                operatorMinus.setBackground(Color.YELLOW);
                operatorMulti.setBackground(Color.YELLOW);
                operatorDivine.setBackground(Color.YELLOW);
                if (source == operatorPlus) {
                    System.out.println("+");
                    pickedOp = "+";
                } else if (source == operatorMinus) {
                    System.out.println("-");
                    pickedOp = "-";
                } else if (source == operatorMulti) {
                    System.out.println("*");
                    pickedOp = "*";
                } else if (source == operatorDivine) {
                    System.out.println("/");
                    pickedOp = "/";
                }
                source.setBackground(Color.ORANGE);
                opIsPicked = true;

            } else if ((source == buttonNum1 || source == buttonNum2 || source == buttonNum3 || source == buttonNum4)
                    && (opIsPicked) && (source != memX)) {

                if (source == buttonNum1) {
                    numY = numA;
                    denomY = denomA;
                } else if (source == buttonNum2) {
                    numY = numB;
                    denomY = denomB;
                } else if (source == buttonNum3) {
                    numY = numC;
                    denomY = denomC;
                } else if (source == buttonNum4) {
                    numY = numD;
                    denomY = denomD;
                }
                operatorPlus.setBackground(Color.YELLOW);
                operatorMinus.setBackground(Color.YELLOW);
                operatorMulti.setBackground(Color.YELLOW);
                operatorDivine.setBackground(Color.YELLOW);
                System.out.println("numY = " + numY);
                System.out.println("denomY = " + denomY);

                switch (pickedOp) {
                    case "+":
                        numY = (numX * denomY) + (numY * denomX);
                        denomY = denomX * denomY;
                        System.out.println("new numY = " + numY);
                        System.out.println("new denomY = " + denomY);
                        break;
                    case "-":
                        numY = (numX * denomY) - (numY * denomX);
                        denomY = denomX * denomY;
                        System.out.println("new numY = " + numY);
                        System.out.println("new denomY = " + denomY);
                        break;
                    case "*":
                        numY = numX * numY;
                        denomY = denomX * denomY;
                        System.out.println("new numY = " + numY);
                        System.out.println("new denomY = " + denomY);
                        break;
                    case "/":
                        dividend = numX * denomY;
                        divisor = denomX * numY;
                        numY = dividend;
                        denomY = divisor;
                        System.out.println("new numY = " + numY);
                        System.out.println("new denomY = " + denomY);
                        break;
                }
                System.out.println("---------------------------------------------");

                if (numY % denomY != 0 && denomY != 0) {
                    result = numY / denomY;
                    source.setText(String.format("%.0f/%.0f", numY, denomY));
                } else if (denomY == 0) {
                    source.setText("error");
                    source.setEnabled(false);
                } else {
                    result = numY / denomY;
                    source.setText(String.format("%.0f", result));
                    numY = result;
                    denomY = 1;
                }

                if (source == buttonNum1) {
                    numA = numY;
                    denomA = denomY;
                } else if (source == buttonNum2) {
                    numB = numY;
                    denomB = denomY;
                } else if (source == buttonNum3) {
                    numC = numY;
                    denomC = denomY;
                } else if (source == buttonNum4) {
                    numD = numY;
                    denomD = denomY;
                }

                if (result == 24) {
                    source.setBackground(Color.GREEN);
                }
                memX.setText("");
                memX.setEnabled(false);
                play();
            } else if (source == next && result == 24) {
                n++;
                stagenum++;
                aList.add(generateProblem());
                stage.setText("Stage "+ stagenum);
                newGame();
            } else if (source == soln) {
                soln.setText(aList.get(n).getSol());
                soln.setFont(new Font("sol", Font.PLAIN, 14));
                soln.setBackground(Color.RED);
            } else if (source == reset) {
                newGame();
            }
        }
    }
}