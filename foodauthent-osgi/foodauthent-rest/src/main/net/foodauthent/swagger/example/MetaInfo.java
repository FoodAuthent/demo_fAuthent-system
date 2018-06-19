package net.foodauthent.swagger.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/meta")
@Api(value = "/meta")
public interface MetaInfo {

	@GET
	@ApiOperation(value = "Get meta information")
	String getInfo();

}