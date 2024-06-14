import java.util.ArrayList;
import java.lang.System;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.NoSuchElementException;


public class BracketChecker {

	public static interface Stack<T> {
		public void push(T e);

		public void pop() throws NoSuchElementException;

		public T top() throws NoSuchElementException;

		public boolean isEmpty();

		public int size();
	}

	public static class ArrayStack<T> implements Stack<T> {
		private final Object[] objects;
		private int leSize;

		public ArrayStack(int capacity) {
			objects = new Object[capacity];
			leSize = -1;
		}

		@Override
		public void push(T e) {
			if (leSize == objects.length - 1) throw new IndexOutOfBoundsException("Stack overflow");
			objects[++leSize] = e;
		}

		@Override
		public void pop() throws NoSuchElementException {
			if (isEmpty()) throw new NoSuchElementException("Stack is empty");
			objects[leSize] = null;
			leSize--;
		}

		@Override
		public T top() throws NoSuchElementException {
			if (isEmpty()) throw new NoSuchElementException("Stack is empty");
			return (T) objects[leSize];
		}

		@Override
		public boolean isEmpty() {
			return leSize == -1;
		}

		@Override
		public int size() {
			return leSize + 1;
		}


	}


	public static boolean check(String toCheck, int capacity) {
		ArrayStack<Character> stack = new ArrayStack<Character>(capacity);
		for (char character : toCheck.toCharArray()) {
			if (character == '(' || character == '[' || character == '{') stack.push(character);
			else if (character == ')' || character == ']' || character == '}') {
				if (stack.isEmpty()) return false;
				char top = stack.top();
				if ((character == ')' && top != '(') || (character == ']' && top != '[') || (character == '}' && top != '{'))
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();


	}


	private static String[] readStringArray(String filename) {
		// open a file, read its lines, return them as an array.

		try {

			ArrayList<String> lines = new ArrayList<String>();

			// Kein Scanner, wÃ¤re viel zu langsam
			// Erzwingen von UTF-8 (sonst komische Ergebnisse unter Windows)
			Reader in = new InputStreamReader(new FileInputStream(filename),
					"UTF-8");

			BufferedReader reader = new BufferedReader(in);

			String s;
			while ((s = reader.readLine()) != null) {
				if (s.length() != 0)
					lines.add(s);
			}

			reader.close();

			String[] result = new String[lines.size()];
			return lines.toArray(result);

		} catch (IOException e) {

			String msg = "I/O-Fehler bei " + filename + "\n" + e.getMessage();
			throw new RuntimeException(msg);

		}

	}


	public static void checkFile(String filepath) {
		String[] lines = readStringArray(filepath);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lines.length; ++i) {
			sb.append(lines[i]);
		}
		String content = sb.toString();
		System.out.format("File %s correct? %b", filepath,
				check(content, 1000));
	}


	public static void main(String[] args) {
		checkFile("Yourfile.java");
	}

}
