package com.jerem.service;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Interface BSCarLoanSubscription.<br/>
 * BRED - Banque populaire
 * @author BredBanquePopulaire
 */
@Consumes({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
@Path("/")
@Produces({ javax.ws.rs.core.MediaType.APPLICATION_JSON })
@Api(value = "BSCarLoanSubscription", produces = "application/json")
public interface BSCarLoanSubscription {

    @POST
    @Path("/hello1/{workcaseId}")
    @ApiOperation(value = "activateCarLoan", response = Boolean.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "activateCarLoan OK"), @ApiResponse(code = 404, message = "activateCarLoan KO") })
    Boolean activateCarLoan(@BeanParam fr.bred.common.soa.auth.ServiceContext serviceContext, @PathParam("workcaseId") Integer workcaseId);

    @GET
    @Path("/save")
    @ApiOperation(value = "save", response = Boolean.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "save OK"), @ApiResponse(code = 404, message = "save KO") })
    Boolean save();

    @GET
    @Path("/findAll")
    @ApiOperation(value = "findAll", response = Boolean.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "findAll OK"), @ApiResponse(code = 404, message = "findAll KO") })
    Boolean findAll();

    @GET
    @Path("/find/{name}")
    @ApiOperation(value = "find", response = Boolean.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "find OK"), @ApiResponse(code = 404, message = "find KO") })
    Boolean find(@PathParam("name") String name);

    @POST
    @Path("/hello2")
    Boolean lockTask(@BeanParam fr.bred.common.soa.auth.ServiceContext serviceContext, WorkcaseContext workcaseContext);

}
