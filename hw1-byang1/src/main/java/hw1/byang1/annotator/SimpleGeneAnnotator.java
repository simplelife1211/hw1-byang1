package hw1.byang1.annotator;

import hw1.byang1.annotation.NamedEntity;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

/**
 * SimpleGeneAnnotator is an annotator to extract GeneTag corpus 
 * from raw sentences provided in offset representation.
 * 
 * @author Bo Yang
 */
public class SimpleGeneAnnotator extends JCasAnnotator_ImplBase {
	
	private Chunker chunker;

	/**
	 * Extracts GeneTag corpus from raw sentences provided in 
	 * offset representation.
	 * <p>
	 * This method uses chunker provided by lingpipe.
	 * 
	 * @param aJCas the JCas containing of Sofa and annotation
	 * @see JCasAnnotator_ImplBase#process(JCas)
	 */
	public void process(JCas aJCas) {
		// gets chunker
		File modelFile = new File("./src/main/resources/ne-en-bio-genetag.HmmChunker");
		try {
			chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// gets document text
		String docText = aJCas.getDocumentText();
		String[] sentences = docText.split("\n");
		
		// parses document
		for (String sentence : sentences) {
			// divides sentence into id and raw sentence
			String[] content = sentence.split(" ", 2);
			String id = content[0];
			Integer idSize = id.length();
			// parses raw sentence with chunker
		    Chunking chunking = chunker.chunk(content[1]);
		    Set<Chunk> chunkSet = chunking.chunkSet();
		    // transforms chunks into annotations
		    for (Chunk chunk : chunkSet) {
		    	NamedEntity annotation = new NamedEntity(aJCas);
		    	annotation.setContent(content[1].substring(chunk.start(), chunk.end()));
		    	int beginBlank = 0;
		    	for (int i = 0; i < chunk.start(); i++) {
		    		if (content[1].charAt(i) == ' ')
		    			beginBlank++;
		    	}
		    	int endBlank = beginBlank;
		    	for (int i = chunk.start(); i < chunk.end(); i++) {
		    		if (content[1].charAt(i) == ' ')
		    			endBlank++;
		    	}
		    	annotation.setBegin(chunk.start() - beginBlank);
		    	annotation.setEnd(chunk.end() - endBlank - 1);
		    	annotation.setId(id);
		    	annotation.addToIndexes();
		    }
		}
	}
}
