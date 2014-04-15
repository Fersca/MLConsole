import render.Lib;
import useCases.*

//Inicia la aplicaci—n
class MainMenu {

	static view() {
		def pantalla = []
		pantalla << ["titulo":"Bienvenido a ML Console, Site: ${Lib.siteId}"]
		pantalla << ["linea":"Menu principal"]
		pantalla << ["texto":"Elija la opcion que desea"]
		pantalla << ["grilla":[	[contenido:"Home",action:{HomePage.view()}],
								[contenido:"Vip",action:{ViewItemPage.view()}],
								[contenido:"Listados",action:{Listings.view()}]
							 ]]
		pantalla << ["linea":""]
		Lib.show pantalla
	}
	
}