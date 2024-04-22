package interpretedLanguagesHW;
import java.io.*;
import java.util.*;

public class LeagueOfLanguageInterpreter {
    private List<String> instructions;
    private Deque<Integer> stack;
    private int pc;

    public LeagueOfLanguageInterpreter(String fileName) throws IOException {
        this.instructions = new ArrayList<>();
        this.stack = new ArrayDeque<>();
        this.pc = 0;
        loadInstructions("src/" + fileName);
    }

    private void loadInstructions(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            instructions.add(line);
        }
        reader.close();
    }

    private void executeInstruction(String instruction, String[] parts) {
        switch (instruction) {
            case "NUNU":
                stack.push(0);
                break;
            case "LEBLANC":
                if (!stack.isEmpty()) {
                    stack.push(stack.peek());
                }
                break;
            case "YUUMI":
                if (!stack.isEmpty()) {
                    stack.push(stack.pop() + 1);
                }
                break;
            case "ZAC":
                if (stack.size() >= 2) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b * a);
                }
                break;
            case "THRESH":
                try {
                    System.out.println("Enter a number:");
                    Scanner scanner = new Scanner(System.in);
                    int inputDigit = scanner.nextInt();
                    stack.push(inputDigit);
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a digit.");
                }
                break;
            case "ALISTAR":
                try {
                    System.out.println("Enter a string:");
                    Scanner scanner = new Scanner(System.in);
                    String inputLine = scanner.nextLine();
                    for (char c : inputLine.toCharArray()) {
                        stack.push((int) c);
                    }
                } catch (Exception e) {
                    System.err.println("An error occurred while reading input.");
                }
                break;
            case "POPPY":
                if (!stack.isEmpty()) {
                    System.out.print((char) stack.pop().intValue());
                }
                break;
            case "HEIMER":
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
                break;
            case "ANNIE":
                while (!stack.isEmpty()) {
                    System.out.print((char) stack.pop().intValue());
                }
                break;
            case "JHIN":
                if (!stack.isEmpty() && pc < instructions.size()) {
                    int condition = stack.pop();
                    if (condition == 0) {
                        pc = Integer.parseInt(parts[1]) - 1; // Adjust for zero-based index
                    }
                }
                break;
            case "TAHMKENCH":
                if (!stack.isEmpty()) {
                    int value = stack.pop();
                    stack.addFirst(value);
                }
                break;
            case "JANNA":
                if (!stack.isEmpty()) {
                    int value = stack.removeFirst();
                    stack.push(value);
                }
                break;
            case "PYKE":
                pc = instructions.size(); // Terminate the program
                break;
            case "BLITZCRANK":
                try {
                    System.out.println("Enter a character:");
                    Scanner scanner = new Scanner(System.in);
                    String inputCharacter = scanner.nextLine();
                    if (inputCharacter.length() == 1) {
                        stack.push((int) inputCharacter.charAt(0));
                    } else if(inputCharacter.length() == 1){
                        System.err.println("Try again, please enter a character");
                    }
                    else {
                    	System.err.println("Try again, please only enter one character");
                    }
                } catch (Exception e) {
                    System.err.println("An error occurred while reading input.");
                }
                break;
            case "KLED":
                if (stack.size() == 2) {
                    int count = stack.pop();
                    int charValue = stack.pop();
                    char character = (char) charValue;
                    for (int i = 0; i < count; i++) {
                        System.out.print(character);
                    }
                } else {
                    System.err.println("Error: Insufficient data on stack for KLED operation.");
                }
                break;
            case "KAYN":
                Deque<Integer> tempStack = new ArrayDeque<>();
                while (!stack.isEmpty()) {
                    tempStack.push(stack.pop());
                }
                stack = tempStack;
                break;


        }
    }

    public void run() {
        while (pc < instructions.size()) {
            String instructionLine = instructions.get(pc).trim();
            if (!instructionLine.isEmpty()) {
                String[] parts = instructionLine.split("\\s+");
                executeInstruction(parts[0], parts);
            }
            pc++; // Increment the program counter unless modified by JHIN
        }
    }

    public static void main(String[] args) {
        String[] programs = {"cat.rift"};
        for (String program : programs) {
            try {
                System.out.println("=================================");
                System.out.println("Executing program: " + program);
                LeagueOfLanguageInterpreter interpreter = new LeagueOfLanguageInterpreter(program);
                interpreter.run();
                System.out.println();
            } catch (IOException e) {
                System.err.println("Failed to load program: " + e.getMessage());
            }
        }
    }
}
