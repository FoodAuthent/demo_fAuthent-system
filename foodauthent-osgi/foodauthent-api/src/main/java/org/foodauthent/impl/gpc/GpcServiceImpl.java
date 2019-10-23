package org.foodauthent.impl.gpc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.foodauthent.api.GpcService;
import org.foodauthent.common.exception.FAExceptions;
import org.foodauthent.gpc.Brick;
import org.foodauthent.gpc.GpcBricks;
import org.foodauthent.model.GPCAttributeData;
import org.foodauthent.model.GPCAttributeValueData;
import org.foodauthent.model.GPCBrickData;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service = GpcService.class)
public class GpcServiceImpl implements GpcService {
    private GpcBricks bricks;

    @Override
    public List<GPCBrickData> findGpcBricks(String s, String lang)
	    throws FAExceptions.UnauthorizedResponse, FAExceptions.ModelNotFoundResponse, FAExceptions.FAException {
	final Map<String, Brick> found = bricks.findBricks(lang, s);
	List<GPCBrickData> result = found.values().stream().map(b -> {
	    return GPCBrickData.builder() //
		    .setCode(b.getCode()) //
		    .setText(b.getText().get(lang)) //
		    .setElements(b.getAttributes().stream().map(a -> {
			return GPCAttributeData.builder()//
				.setCode(a.getCode()) //
				.setText(a.getText().get(lang))//
				.setElements(a.getValues().stream().map(v -> {
				    return GPCAttributeValueData.builder() //
					    .setCode(v.getCode()).setText(v.getText().get(lang)) //
					    .build();
				}).collect(Collectors.toList())).build();
		    }).collect(Collectors.toList())).build();
	}).collect(Collectors.toList());
	if (result.isEmpty()) {
	    throw new FAExceptions.ModelNotFoundResponse("no model found for " + s);
	}
	return result;
    }

    @Activate
    public void activate() throws Exception {
	bricks = new GpcBricks();
    }

}
