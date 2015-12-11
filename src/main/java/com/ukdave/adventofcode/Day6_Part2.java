package com.ukdave.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Advent of Code - Day 6 Part 2.
 * 
 * @author uk_dave
 */
public class Day6_Part2 {

	public static void main(final String[] args) throws IOException {
		int[][] lights = new int[1000][1000];
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(Day6_Part2.class.getResourceAsStream("/day6.txt")))) {
			Pattern p = Pattern.compile("(.*) ([0-9]+),([0-9]+) through ([0-9]+),([0-9]+)");
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				Matcher m = p.matcher(line);
				if (!m.matches()) {
					continue;
				}
				
				String mode = m.group(1);
				int startX = Integer.parseInt(m.group(2));
				int startY = Integer.parseInt(m.group(3));
				int endX = Integer.parseInt(m.group(4));
				int endY = Integer.parseInt(m.group(5));
				
				for (int x = startX; x <= endX; x++) {
					for (int y = startY; y <= endY; y++) {
						if (mode.equals("turn on")) {
							lights[x][y]++;
						} else if (mode.equals("turn off")) {
							lights[x][y]--;
							if (lights[x][y] < 0) {
								lights[x][y] = 0;
							}
						} else if (mode.equals("toggle")) {
							lights[x][y] += 2;
						}
					}
				}
			}
		}
		
		int totalBrightness = 0;
		for (int x = 0; x < 1000; x++) {
			for (int y = 0; y < 1000; y++) {
				totalBrightness += lights[x][y];
			}
		}
		System.out.println(totalBrightness); // 14687245
	}
}
