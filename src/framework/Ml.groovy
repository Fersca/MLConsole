package framework

class Ml {

	/**
	 * Return the list of Featured Real State Agencies
	 * @param siteId
	 * @return
	 */
	static def getFeaturedRealState(def siteId){
		
		def result = HttpClient.getContent("https://api.mercadolibre.com/sites/${siteId}/dealers/search?category=${siteId}1743")
		
		def realState = []
		
		result[0..2].each {
			def real = [:]
			real.name = it.name
			real.link = it.link
			realState << real
		}
		
		return realState

	}
	
	/**
	 * Return the list of news about Motors
	 * @return
	 */
	static def getMotorNews(def siteId){
		
		def result = HttpClient.getContent("https://api.mercadolibre.com/sites/${siteId}/news/search?site_id=${siteId}&category=${siteId}1743")
				
		def newsList = []
		
		result[0..2].each {
			def news = [:]
			news.topic = it.fields.tags
			news.news = "${it.body[0..50]} ...."
			newsList << news
		}

		return newsList
		
	}
	/**
	 * Return the Hot Items (Most sold items in the last hour)
	 * @return
	 */
	static def getHotItems(def siteId){
		
		def result = HttpClient.getContent("https://api.mercadolibre.com/sites/${siteId}/hot_items/search")
		
		def hot = []
		
		result.results[0..5].each {
			def item = [:]
			item.itemId = it.id
			item.price = it.site_id
			item.title = it.title
			item.price = it.price
			hot << item
		}

		return hot
	}
	
	/**
	 * return the Home Featured Items (The items that will appear in the home page due to its price range)
	 * @return
	 */
	static def getFeaturedItems(def siteId){
		
		def result = HttpClient.getContent("https://api.mercadolibre.com/sites/${siteId}/featured_items/HP")
		
		def favoritos = []
		
		result[0..5].each {
			def item = [:]
			item.itemId = it.item_id
			item.price = it.price
			item.title = it.title
			favoritos << item
		}

		return favoritos
	}

}
