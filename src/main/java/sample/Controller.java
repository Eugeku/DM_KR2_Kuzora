package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class Controller {
    @FXML
    RadioButton radioButton1, radioButton2;
    @FXML
    HBox hBox1;
    @FXML
    Button button1, button2, button3;
    @FXML
    Label label1, label2;
    @FXML
    TextField textField1;
    @FXML
    TextArea textArea1, textArea2;
    private Data data = new Data();
    private String textArea1Text = "";
    private String textArea2Text = "";

    public void setRadioButton1(ActionEvent event) {
        if (radioButton1.isSelected()) {
            radioButton1.setSelected(true);
            radioButton2.setSelected(false);
            if (data.getValue() == 0) {
                label1.setText("Введите a");
                textField1.setPromptText("a");
            }
            hBox1.setVisible(true);
            button1.setVisible(true);
            label2.setText("Нахождение значения 1-ой и 2-ой\n" +
                    "производной функции вида:\n" +
                    "F(x)=x/(sqrt(1+x*x)) при x=(a+b)/2");
            label2.setVisible(true);
            button3.setVisible(true);
        } else {
            hBox1.setVisible(false);
            button1.setVisible(false);
            label2.setVisible(false);
            button3.setVisible(false);
        }
    }

    public void setRadioButton2(ActionEvent event) {
        if (radioButton2.isSelected()) {
            radioButton2.setSelected(true);
            radioButton1.setSelected(false);
            if (data.getValue() == 0) {
                label1.setText("Введите a");
                textField1.setPromptText("a");
            }
            hBox1.setVisible(true);
            button1.setVisible(true);
            label2.setText("Вычисление значения интеграла\n" +
                    "функции вида:\n" +
                    "F(x)=sin(x) при x=[a,b]");
            label2.setVisible(true);
            button3.setVisible(true);
        } else {
            hBox1.setVisible(false);
            button1.setVisible(false);
            label2.setVisible(false);
            button3.setVisible(false);
        }
    }

    public void setButton1(ActionEvent event) {
        try {
            if (radioButton1.isSelected() & data.getValue() == 0) {
                try {
                    data.setA(Double.parseDouble(textField1.getText()));
                    textArea1Text += String.format("a=%-5.3f\n", data.getA());
                    textArea1.setText(textArea1Text);
                    label1.setText("Введите b");
                    textField1.clear();
                    textField1.setPromptText("b");
                } catch (Exception e) {
                    label1.setText("Повторите ввод a");
                    textField1.clear();
                    textField1.setPromptText("a");
                    throw e;
                }
            } else if (radioButton2.isSelected() & data.getValue() == 0) {
                try {
                    data.setA(Double.parseDouble(textField1.getText()));
                    textArea1Text += String.format("a=%-5.3f\n", data.getA());
                    textArea1.setText(textArea1Text);
                    label1.setText("Введите b");
                    textField1.clear();
                    textField1.setPromptText("b");

                } catch (Exception e) {
                    label1.setText("Повторите ввод a");
                    textField1.clear();
                    textField1.setPromptText("a");
                    throw e;
                }
            }
            if (radioButton1.isSelected() & data.getValue() == 1) {
                try {
                    data.setB(Double.parseDouble(textField1.getText()));
                    textArea1Text += String.format("b=%-5.3f\n", data.getB());
                    textArea1.setText(textArea1Text);
                    label1.setText("Введите n");
                    textField1.clear();
                    textField1.setPromptText("n");
                } catch (Exception e) {
                    label1.setText("Повторите ввод b");
                    textField1.clear();
                    textField1.setPromptText("b");
                    throw e;
                }
            } else if (radioButton2.isSelected() & data.getValue() == 1) {
                try {
                    data.setB(Double.parseDouble(textField1.getText()));
                    textArea1Text += String.format("b=%-5.3f\n", data.getB());
                    textArea1.setText(textArea1Text);
                    label1.setText("Введите n");
                    textField1.clear();
                    textField1.setPromptText("n");
                } catch (Exception e) {
                    label1.setText("Повторите ввод b");
                    textField1.clear();
                    textField1.setPromptText("b");
                    throw e;
                }
            }
            if (radioButton1.isSelected() & data.getValue() == 2) {
                try {
                    int n = Integer.parseInt(textField1.getText());
                    if (n < 3) throw new Exception();
                    data.setN(n);
                    textArea1Text += String.format("n=%-3d\n", data.getN());
                    textArea1.setText(textArea1Text);
                    textField1.clear();
                    textField1.setPromptText("");
                    hBox1.setDisable(true);
                    button1.setDisable(true);
                    button3.setDisable(false);
                } catch (Exception e) {
                    label1.setText("Повторите ввод n");
                    textField1.clear();
                    textField1.setPromptText("n");
                    throw e;
                }
            } else if (radioButton2.isSelected() & data.getValue() == 2) {
                try {
                    int n = Integer.parseInt(textField1.getText());
                    if (n < 3) throw new Exception();
                    data.setN(n);
                    textArea1Text += String.format("n=%-3d\n", data.getN());
                    textArea1.setText(textArea1Text);
                    textField1.clear();
                    textField1.setPromptText("");
                    hBox1.setDisable(true);
                    button1.setDisable(true);
                    button3.setDisable(false);
                } catch (Exception e) {
                    label1.setText("Повторите ввод n");
                    textField1.clear();
                    textField1.setPromptText("n");
                    throw e;
                }
            }
            data.incValue();
        } catch (Exception e) {
            //end of outer block try-catch
        }
    }

    public void setButton2(ActionEvent event) {
        textArea1Text = "";
        textArea1.clear();
        data.setValue(0);
        data.setA(0);
        data.setB(0);
        data.setN(0);
        label1.setText("Введите a");
        textField1.setPromptText("a");
        hBox1.setDisable(false);
        button1.setDisable(false);
        textArea2.clear();
        button3.setDisable(true);
    }

    public void setButton3(ActionEvent event) {
        if (radioButton1.isSelected()) {
            Spline spline = new Spline(data.getA(), data.getB(), data.getN());
            spline.splineMethod();
            textArea2Text = "";
            textArea2Text += String.format("\tРезультаты вычислений 1-ой и 2-ой \nпроизводной заданной функции " +
                    "при x = %5.3f \nf'(%5.3f)=%f \n" +
                    "f\"(%5.3f)=%f", spline.getX(), spline.getX(), spline.getY_1(), spline.getX(), spline.getY_2());
            textArea2.setText(textArea2Text);
        }

        if (radioButton2.isSelected()) {
            QuadroGauss quadroGauss = new QuadroGauss(data.getA(), data.getB());
            quadroGauss.gaussMethod();
//            Simpson simpson = new Simpson(data.getA(), data.getB());
//            simpson.simpsonMethod();
            textArea2Text = "";
            textArea2Text += String.format("\tРезультаты вычислений интеграла \nзаданной функции " +
                            "при x =[%5.2f,%5.2f],\nОтвет: %f\nПогрешность: %f", quadroGauss.getA(),
                    quadroGauss.getB(), quadroGauss.getRes(), quadroGauss.getD());
//            textArea2Text += String.format("\tРезультаты вычислений интеграла \nзаданной функции " +
//                            "при x =[%5.2f,%5.2f],\nОтвет: %f\nПогрешность: %f", simpson.getA(),
//                    simpson.getB(), simpson.getRes(), simpson.getD());
            textArea2.setText(textArea2Text);
        }
    }
}


