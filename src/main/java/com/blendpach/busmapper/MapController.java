package com.blendpach.busmapper;

import org.springframework.stereotype.Controller;

// import com.mkyong.web.location.ServerLocation;
// import com.mkyong.web.location.ServerLocationBo;

@Controller
public class MapController {

	// @GetMapping("/site/{sheetId}")
	// public function getSite(@PathVariable("sheetId") sheetId: String?, model:
	// ModelAndView): ModelAndView {
	// val sheetsService = Sheets.Builder(
	// HTTP_TRANSPORT,
	// JSON_FACTORY,
	// null
	// ).setSheetsRequestInitializer(SheetsRequestInitializer(googleKey)).build()

	// val response: BatchGetValuesResponse = sheetsService.spreadsheets().values()
	// .batchGet(sheetId).setRanges(listOf("items!A3:Z", "siteinfo!A3:Z"))
	// .execute();
	// val values = response.getValueRanges();

	// model.addObject("items", buildItems(values))
	// model.addObject("site", buildSiteMeta(values))
	// model.addObject("mapsKey", googleKey)
	// model.setViewName("site")
	// return model
	// }

}
