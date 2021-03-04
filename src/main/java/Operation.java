import java.util.Scanner;


public class Operation {
    public static void main(String[] args) {
        Operation operation = new Operation();
        Summ summ = new Summ();
        Minus minus = new Minus();
        Multiple multiple = new Multiple();
        Division division = new Division();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите число (Введите операцию) Введите число");
            System.out.println("Для выхода введите 'q'");
            String str = in.nextLine();
            if ("q".equals(str)) {
                break;
            }
            if (str.contains("+")) {
                str = summ.execute(str);
            } else if (str.contains("*")) {
                str = multiple.execute(str);
            } else if (str.contains("/")) {
                str = division.execute(str);
            } else if (str.contains("-")) {
                str = minus.execute(str);
            } else {
                str = operation.execute(str);
            }
            System.out.println("Результат:" + str);
        }

    }

    String execute(String str) {
        str = "Введена непонятная операция, проверьте введенные данные в результате и введите корректную операцию";
        return str;
    }
}


class Summ extends Operation {
    @Override
    String execute(String str) {
        String[] arrNumbers = str.split("[+]");
        if (arrNumbers.length != 0) {
            float number1 = Float.parseFloat(arrNumbers[0]);
            float number2 = Float.parseFloat(arrNumbers[1]);
            float result = number1 + number2;
            str = Float.toString(result);
        } else {
            str = "Введена непонятная операция, проверьте введенные данные в результате и введите корректную операцию";
        }
        return str;
    }
}

class Minus extends Operation {

    @Override
    String execute(String str) {
        boolean mark = true;
        String[] arrNumbers = str.split("[-]");
        if (arrNumbers.length != 0) {
            for (int i = 0; i < arrNumbers.length; i++) {
                if (arrNumbers[i].equals("")) {
                    arrNumbers[i] = "-" + arrNumbers[i + 1];
                    if (arrNumbers[1].contains("-")) {
                        break;
                    }
                    if (arrNumbers.length > 2) {
                        arrNumbers[i + 1] = arrNumbers[i + 2];
                    }
                    if (arrNumbers.length > 3) {
                        while (mark) {
                            arrNumbers[i + 2] = arrNumbers[i + 3];
                            mark = false;
                        }
                    }
                }
            }
            if (arrNumbers.length >= 2) {
                float number1 = Float.parseFloat(arrNumbers[0]);
                float number2 = Float.parseFloat(arrNumbers[1]);
                float result = number1 - number2;
                str = Float.toString(result);
            }
        } else {
            str = "Введена непонятная операция, проверьте введенные данные в результате и введите корректную операцию";
        }
        return str;
    }
}

class Multiple extends Operation {

    @Override
    String execute(String str) {
        String[] arrNumbers = str.split("[*]");
        if (arrNumbers.length != 0) {
            float number1 = Float.parseFloat(arrNumbers[0]);
            float number2 = Float.parseFloat(arrNumbers[1]);
            float result = number1 * number2;
            str = Float.toString(result);
        } else {
            str = "Введена непонятная операция, проверьте введенные данные в результате и введите корректную операцию";
        }
        return str;
    }
}

class Division extends Operation {

    @Override
    String execute(String str) {
        String[] arrNumbers = str.split("[/]");
        if (arrNumbers.length != 0) {
            float number1 = Float.parseFloat(arrNumbers[0]);
            float number2 = Float.parseFloat(arrNumbers[1]);
            if (number2 == 0) {
                str = "На ноль делить нельзя";
            } else {
                float result = number1 / number2;
                str = Float.toString(result);
            }
        } else {
            str = "Введена непонятная операция, проверьте введенные данные в результате и введите корректную операцию";
        }
        return str;
    }
}
