package hw1.byang1.evaluation;

import java.io.File;
import java.io.IOException;

import org.apache.uima.util.FileUtils;

public class ResultEvaluator {

	/**
	 * @param args my result file and reference output file
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File myFile = new File(args[0]);
		File sdFile = new File(args[1]);
		String[] myGeneTags = FileUtils.file2String(myFile).split("\n");
		String[] sdGeneTags = FileUtils.file2String(sdFile).split("\n");
		Integer hit = 0;
		Integer miss = 0;
		Integer wrong = 0;
		int i = 0, j = 0;
		while (i < myGeneTags.length && j < sdGeneTags.length) {
			if (myGeneTags[i].compareTo(sdGeneTags[j]) == 0) {
				hit++;
				i++;
				j++;
				continue;
			}
			String[] myTag = myGeneTags[i].split("\\|");
			String[] sdTag = sdGeneTags[j].split("\\|");
			String myLineId = myTag[0];
			String sdLineId = sdTag[0];
			///////////////////////////////////
//			System.out.println(myGeneTags[i]);
//			System.out.println(myTag[0] + "@@" +myTag[1]);
//			System.out.println(myTag[1]);
//			System.out.println(myTag[1].split(" ")[0]);
			///////////////////////////////////
			Integer myStart = Integer.parseInt(myTag[1].split(" ")[0]);
			Integer sdStart = Integer.parseInt(sdTag[1].split(" ")[0]);
			Integer compare = myLineId.compareTo(sdLineId);
			if (compare == 0) {
				if (myStart < sdStart) {
					wrong++;
					i++;
					continue;
				} else {
					miss++;
					j++;
					continue;
				}
			}
			if (compare < 0) {
				wrong++;
				i++;
				continue;
			} else {
				miss++;
				j++;
				continue;
			}
		}
		
		if (i < myGeneTags.length)
			wrong = wrong + myGeneTags.length - i;
		if (j < sdGeneTags.length)
			miss = miss + sdGeneTags.length - j;
		
		System.out.println("hit: " + hit);
		System.out.println("miss: " + miss);
		System.out.println("wrong: " + wrong);

	}

}
