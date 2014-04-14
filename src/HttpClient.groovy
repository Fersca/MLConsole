import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import groovy.json.JsonSlurper

public class HttpClient {

	/**
	 * Devuelve el contenido de una URL (en formato json plano)
	 * @param urlToFetch
	 * @return
	 * @throws Exception
	 */
	static def getContent(String urlToFetch) throws Exception {
				
		//get URL content
		URL url = new URL(urlToFetch)
		print "."
		HttpURLConnection conn = (HttpURLConnection) url.openConnection()
		print "."
		conn.setRequestProperty("Accept", "application/json")
		print "."

		// open the stream and put it into BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))
		print "."
		String inputLine;
		print "."
		//Guarda el contenido
		StringBuilder contenido= new StringBuilder()
		print "."
		//genera todo el contenido junto
		while ((inputLine = br.readLine()) != null) {
			print "."
			contenido.append(inputLine)
		}
		print "."
		//Devuelve el contendio
		def slurper = new JsonSlurper()
		print "."
		def result = slurper.parseText(contenido.toString())
		println "."
		return result
	}

}
