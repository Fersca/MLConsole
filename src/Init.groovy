import framework.Lib

//Inicia la aplicaci—n
class InitPage {

	public static void main(String[] args){
		InitPage.view()
		MainMenu.view()
	}
	
	static view() {
		
		//action to choose the site		
		def chooseSite = { site ->
			Lib.siteId = site
		}
		
		def sitesList = []
		
		//list of sites
		def sites = ["MLA","MLB","MCO","MCR","MEC","MLC","MLM","MLU","MLV","MPA","MPE","MPT","MRD"]
		
		//create the map with the action
		sites.each {  
			sitesList << [contenido: it, action: chooseSite.curry(it)]
		}
		
		def pantalla = []
		pantalla << ["titulo":"ML Console"]
		pantalla << ["linea":"Sites"]
		pantalla << ["grilla":sitesList]
		pantalla << ["linea":""]
		
		Lib.show pantalla
			
	}
	
}
