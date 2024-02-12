import java.util.*;
public class BinaryDecimalConverter
{

    static Scanner k;

    // Converts a string input of a binary number to a decimal number
    public static String binaryToDecimal(String input)
    {

        // Splits the input into an array of chars and converts it into an array of ints
        char[] chars = input.toCharArray();
        int[] ints = new int[chars.length];

        for (int i = 0; i < ints.length; i++)
        {
            ints[i] = Character.getNumericValue(chars[i]);
        }

        // This is the algorithm for converting the binary number to its decimal equivalent
        int total = ints[0];

        for (int i = 0; i < ints.length-1; i++)
        {
            total = total*2 + ints[i+1];
        }

        return Integer.toString(total);
    }

    // Converts a string input of a decimal number to a binary number
    public static String decimalToBinary(String input)
    {
        // Parses the input
        int decimal = Integer.parseInt(input);

        if (decimal == 0)
            return "0";

        // Uses a Stack to store the remainder after each division by 2
        Stack<Integer> binaryStack = new Stack<>();

        // This is the algorithm for converting to binary
        while (decimal != 0)
        {
            binaryStack.push(decimal%2);
            decimal /= 2;
        }

        StringBuilder result = new StringBuilder();

        // Uses the Stack.pop() method to add the reverse sequence of bits onto a String representation of the result
        while (!binaryStack.empty())
        {
            result.append(binaryStack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args)
    {

        k = new Scanner(System.in);

        boolean done = false;

        // Presents a menu of options for the user
        while (!done)
        {

            System.out.println("Enter '1' for binary to decimal conversion");
            System.out.println("Enter '2' for decimal to binary conversion");
            System.out.println("or enter 'q' to quit: ");

            String response = k.next();

            switch (response)
            {
                case "1": option1();
                    break;
                case "2": option2();
                    break;
                case "q": done = true;
                    break;
                default:
                    System.out.println("Invalid input!");
            }

        }

        k.close();
    }

    // Checks for valid input and calls the binaryToDecimal method
    public static void option1()
    {
        boolean done = false;

        while (!done)
        {
            System.out.print("Enter a binary (base 2) number (or q to go back): ");

            String s = k.next();

            if (s.equals("q"))
                done = true;
            else if (s.matches("[01]+"))
            {
                System.out.println("Decimal: " + binaryToDecimal(s));
            }
            else
            {
                System.out.println(s + " is not a binary number!");
            }
        }
    }

    // Checks for valid input and calls the decimalToBinary method
    public static void option2()
    {
        boolean done = false;

        while (!done)
        {
            System.out.print("Enter a decimal (base 10) number (or q to go back): ");

            String s = k.next();

            if (s.equals("q"))
                done = true;
            else if (s.matches("[0123456789]+"))
            {
                System.out.println("Binary: " + decimalToBinary(s));
            }
            else
            {
                System.out.println(s + " is not a decimal number!");
            }
        }
    }
}
