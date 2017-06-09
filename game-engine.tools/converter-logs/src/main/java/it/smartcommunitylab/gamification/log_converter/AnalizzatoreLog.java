package it.smartcommunitylab.gamification.log_converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import it.smartcommunitylab.gamification.log_converter.beans.Record;
import it.smartcommunitylab.gamification.log_converter.manager.RecordManager;

public class AnalizzatoreLog {

	private static final Logger logger = Logger.getLogger(AnalizzatoreLog.class);

	private RecordManager recordManager = new RecordManager();

	public AnalizzatoreLog() {
	}

	public void newData(String logfolderPath) throws IOException {
		logger.debug("inizio newData");
		File folder = new File(logfolderPath);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			String nome = listOfFiles[i].getName();
			System.out.println("nome file : " + nome);
			logger.info("nome file : " + nome);
			// nome = nome.replaceFirst("[.][^.]+$", "");
			// if (!nome.contains("NEW"))

			// se non � file non eseguire elabora
			// messaggi di log per avvertire dello skip
			elabora(logfolderPath, nome);
		}
	}

	public void elabora(String logFolderPath, String nome) throws IOException {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		Boolean sovrascrivo = false;
		File f;
		try {
			f = new File(logFolderPath + nome);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			if (!f.getName().contains("NEW")) {// agg sovrascrivo
				fw = new FileWriter(logFolderPath + nome + "-NEW", false);
			} else {
				// to do
				fw = new FileWriter(logFolderPath + nome);
			}
			// in base al type(action) che si vuole filtrare
			Boolean scrivo = false;
			try {
				String inputLine;
				String recordTrasformato = null;
				while ((inputLine = br.readLine()) != null) {

					Record record = recordManager.analizza(inputLine);
					logger.info(record.getType());
					switch (record.getType()) {
					case ACTION:
						recordTrasformato = recordManager.analizzaAction(record);
						break;

					default:
						recordTrasformato = record.getContent();
						break;
					}

					fw.write(recordTrasformato);
					fw.write("\n");

					// String[] elementi = str.split(" ");
					// try {
					// for (int i = 0; i < elementi.length; i++) {
					// if (elementi[i].contains("type=Action"))
					// scrivo = true;
					// }
					// if (scrivo) {
					// for (int i = 0; i < elementi.length; i++) {
					// if (!(elementi[i].contains("payload") || elementi[i]
					// .contains("oldState"))) {
					// fw.write(elementi[i]);
					// if (i != elementi.length - 1) {
					// fw.write(" ");
					// }
					// }
					// }
					// fw.write("\n");
					// scrivo = false;
					// }
					// } catch (FileNotFoundException e) {
					// e.printStackTrace();
					// }
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
