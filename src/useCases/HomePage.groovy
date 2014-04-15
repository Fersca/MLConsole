package useCases

import framework.Lib
import framework.Ml

class HomePage {

	static view() {
		
		//obtiene los destacados
		def favoritos = Ml.getFeaturedItems(Lib.siteId)
		def hot = Ml.getHotItems(Lib.siteId)
		def news = Ml.getMotorNews(Lib.siteId)
		def realState = Ml.getFeaturedRealState(Lib.siteId)
		
		def pantalla = []
		pantalla << ["titulo":"Home de ML"]
		pantalla << ["linea":"Featured Items"]		
		pantalla << ["grilla":favoritos]
		pantalla << ["linea":"Hot Items"]
		pantalla << ["grilla":hot]
		pantalla << ["linea":"Motors News"]
		pantalla << ["grilla":news]
		pantalla << ["linea":"Featured Real State Agencies"]
		pantalla << ["grilla":realState]
		pantalla << ["linea":""]
		
		Lib.show pantalla
			
	}
		
}