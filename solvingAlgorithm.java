import java.text.DecimalFormat;

class solvingAlgorithm {
    public static int operatorCounter(int length, char[] stringArray, char[] operators) {
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (stringArray[i] == operators[0] || stringArray[i] == operators[1])
                counter++;
        }
        return counter;
    }

    public static int getFirstIndex(int length, char[] stringArray, char[] operators) {
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (stringArray[i] == operators[0] || stringArray[i] == operators[1]) {
                index = i;
                i = length;
            }
        }
        return index;
    }

    public static int getLeftIndex(int operatorIndex, char[] stringArray) {
        int index = 0;
        for (int i = 0; i < operatorIndex; i++) {
            if (stringArray[operatorIndex - 1] == ')') {
                for (int j = 0; j < operatorIndex; j++) {
                    if (stringArray[j] == '(')
                        index = j;
                }
            } else if (stringArray[i] == '+' || stringArray[i] == '-' || stringArray[i] == '*' || stringArray[i] == '/' || stringArray[i] == '$') {
                index = i;
            }
        }
        return index;
    }

    public static int getRightIndex(int operatorIndex, char[] stringArray, int length) {
        int index = 0;
        for (int i = length - 1; i > operatorIndex; i--) {
            if (stringArray[operatorIndex + 1] == '(') {
                for (int j = length - 1; j > operatorIndex; j--) {
                    if (stringArray[j] == ')')
                        index = j;
                }
            } else if (stringArray[i] == '+' || stringArray[i] == '-' || stringArray[i] == '*' || stringArray[i] == '/' || stringArray[i] == '$') {
                index = i;
            }
        }
        return index;
    }

    public static String secondOrderSolve(int length, String number, char[] stringArray, char[] operators) {
        String leftMember, rightMember, leftNumber, rightNumber, operationString, result;
        int leftIndex, rightIndex, operatorIndex;
        double operationResult;
        boolean leftNegative = false, rightNegative = false;

        operatorIndex = getFirstIndex(length, stringArray, operators);
        leftIndex = getLeftIndex(operatorIndex, stringArray);
        rightIndex = getRightIndex(operatorIndex, stringArray, length);

        if (stringArray[operatorIndex - 1] == ')') {
            leftNumber = number.substring(leftIndex + 2, operatorIndex - 1);
            leftNegative = true;
        } else
            leftNumber = number.substring(leftIndex + 1, operatorIndex);

        if (stringArray[operatorIndex + 1] == '(') {
            rightNumber = number.substring(operatorIndex + 3, rightIndex);
            rightNegative = true;
        } else
            rightNumber = number.substring(operatorIndex + 1, rightIndex);

        if (number.indexOf('$') == 1)
            leftMember = "$";
        else if (leftNegative)
            leftMember = number.substring(0, leftIndex);
        else
            leftMember = number.substring(0, leftIndex + 1);

        if (number.indexOf("$") == number.length())
            rightMember = "$";
        else if (rightNegative)
            rightMember = number.substring(rightIndex + 1, length);
        else
            rightMember = number.substring(rightIndex, length);

        if (stringArray[operatorIndex] == '*')
            operationResult = Double.parseDouble(leftNumber) * Double.parseDouble(rightNumber);
        else
            operationResult = Double.parseDouble(leftNumber) / Double.parseDouble(rightNumber);

        DecimalFormat twoFormat = new DecimalFormat("###################.##");
        operationString = twoFormat.format(operationResult);

        if (leftNegative && rightNegative)
            result = operationString;
        else if (leftNegative || rightNegative)
            result = "(@" + operationString + ")";
        else
            result = operationString;

        result = leftMember + result + rightMember;
        return result;
    }

    public static String firstOrderSolve(int length, String number, char[] stringArray, char[] operators) {
        String leftMember, rightMember ,leftNumber, rightNumber, result, operationString = "";
        int leftIndex, rightIndex, operatorIndex;
        double operationResult, lNumber, rNumber;
        boolean leftNegative = false, rightNegative = false;

        operatorIndex = getFirstIndex(length, stringArray, operators);
        leftIndex = getLeftIndex(operatorIndex, stringArray);
        rightIndex = getRightIndex(operatorIndex, stringArray, length);

        if (stringArray[operatorIndex - 1] == ')') {
            leftNumber = number.substring(leftIndex + 2, operatorIndex - 1);
            leftNegative = true;
        } else
            leftNumber = number.substring(leftIndex + 1, operatorIndex);

        if (stringArray[operatorIndex + 1] == '(') {
            rightNumber = number.substring(operatorIndex + 3, rightIndex);
            rightNegative = true;
        } else
            rightNumber = number.substring(operatorIndex + 1, rightIndex);

        if (number.indexOf('(') == 1)
            leftMember = "$";
        else if (leftNegative)
            leftMember = number.substring(0, leftIndex);
        else
            leftMember = number.substring(0, leftIndex + 1);

        if (number.indexOf("$") == number.length())
            rightMember = "$";
        else if (rightNegative)
            rightMember = number.substring(rightIndex + 1, length);
        else
            rightMember = number.substring(rightIndex, length);

        lNumber = Double.parseDouble(leftNumber);
        rNumber = Double.parseDouble(rightNumber);

        if (stringArray[operatorIndex] == '+') {
            if(!leftNegative && !rightNegative){
                operationResult = lNumber + rNumber;
                operationString = Double.toString(operationResult);
            }
            else if(leftNegative && rightNegative){
                operationResult = lNumber + rNumber;
                operationString = Double.toString(operationResult);
                operationString = "(@" + operationString + ")";
            }
            else if(leftNegative){
                if(lNumber > rNumber){
                    operationResult = lNumber - rNumber;
                    operationString = Double.toString(operationResult);
                    operationString = "(@"+ operationString +")";
                }
                else if(lNumber < rNumber){
                    operationResult = rNumber - lNumber;
                    operationString = Double.toString(operationResult);
                }
                else{
                    operationResult = 0;
                    operationString = Double.toString(operationResult);
                }
            }
            else{
                if(lNumber < rNumber){
                    operationResult = rNumber-lNumber;
                    operationString = Double.toString(operationResult);
                    operationString = "(@"+ operationString +")";
                }
                else if(lNumber > rNumber){
                    operationResult = lNumber - rNumber;
                    operationString = Double.toString(operationResult);
                }
                else{
                    operationResult = 0;
                    operationString = Double.toString(operationResult);
                }
            }
        } else if (stringArray[operatorIndex] == '-') {
            if (!leftNegative && !rightNegative) {
                if (lNumber > rNumber) {
                    operationResult = lNumber - rNumber;
                    operationString = Double.toString(operationResult);

                    char[] operationStringChar = operationString.toCharArray();
                    int pointIndex = 0;

                    for(int i = 0; i < operationString.length()-1; i++){
                        if(operationStringChar[i] == '.'){
                            pointIndex = i;
                        }
                    }

                    if(operationStringChar[pointIndex+1] == '0'){
                        DecimalFormat doubleFormat = new DecimalFormat("###################.#");
                        operationString = doubleFormat.format(operationResult);
                    }
                } else if (lNumber < rNumber) {
                    operationResult = rNumber - lNumber;
                    operationString = Double.toString(operationResult);
                    operationString = "(@" + operationString + ")";
                } else {
                    operationResult = 0;
                    operationString = Double.toString(operationResult);
                }
            } else if (leftNegative && rightNegative) {
                if (lNumber < rNumber) {
                    operationResult = rNumber - lNumber;
                    operationString = Double.toString(operationResult);
                }
                if (lNumber > rNumber) {
                    operationResult = lNumber - rNumber;
                    operationString = Double.toString(operationResult);
                    operationString = "(@" + operationString + ")";
                }
            } else if (rightNegative) {
                operationResult = lNumber + rNumber;
                operationString = Double.toString(operationResult);
            } else {
                operationResult = lNumber + rNumber;
                operationString = Double.toString(operationResult);
                operationString = "(@" + operationString + ")";
            }

        }
        result = leftMember + operationString + rightMember;

        return result;
    }

    public static String loopSecondOrder(char[] inputArray, String input, int operatorNumber, int arrayLength, char[] operators) {
        String result = "";
        for (int i = 0; i < operatorNumber; i++) {
            if (i == 0)
                result = secondOrderSolve(arrayLength, input, inputArray, operators);
            else
                result = secondOrderSolve(result.length(), result, result.toCharArray(), operators);
        }
        return result;
    }

    public static String loopFirstOrder(char[] inputArray, String input, int operatorNumber, int arrayLength, char[] operators) {
        String result = "";
        for (int i = 0; i < operatorNumber; i++) {
            if (i == 0)
                result = firstOrderSolve(arrayLength, input, inputArray, operators);
            else
                result = firstOrderSolve(result.length(), result, result.toCharArray(), operators);
        }
        return result;
    }

    public static String callFromGui(String operationString){
        String number = "$" + operationString + "$";
        String result;
        char[] inputArray = number.toCharArray();
        char[] firstOperators = {'+', '-'}, secondOperators = {'*', '/'};
        int arrayLength = inputArray.length;
        int firstOperatorCount, secondOperatorCount;

        firstOperatorCount = operatorCounter(arrayLength, inputArray, firstOperators);
        secondOperatorCount = operatorCounter(arrayLength, inputArray, secondOperators);

        if (secondOperatorCount > 0) {
            result = loopSecondOrder(inputArray, number, secondOperatorCount, arrayLength, secondOperators);
            if(firstOperatorCount > 0)
                result = loopFirstOrder(result.toCharArray(), result, firstOperatorCount, result.length(), firstOperators);
        } else
            result = loopFirstOrder(inputArray, number, firstOperatorCount, arrayLength, firstOperators);

        char[] resultArray = result.toCharArray();
        for(int i = 0; i < resultArray.length; i++){
            if(resultArray[i] == '@')
                resultArray[i] = '-';
        }

        result = String.valueOf(resultArray);
        result = result.substring(1, resultArray.length - 1);

        return result;
    }
}