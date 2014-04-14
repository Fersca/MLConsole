//Inicia la aplicación
class MainMenu {

	static view() {
		def pantalla = []
		pantalla << ["titulo":"Bienvenido a ML Console, Site: ${Lib.siteId}"]
		pantalla << ["linea":"Menu principal"]
		pantalla << ["texto":"Elija la opcion que desea"]
		pantalla << ["grilla":[	[contenido:"Home",action:{HomePage.view()}],
								[contenido:"Vip",action:{Vip.view()}],
								[contenido:"Listados",action:{Listados.view()}]
							 ]]
		pantalla << ["linea":""]
		Lib.mostrar pantalla
	}
	
}