package com.qa.rest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETCallWithBDD {
	
	@Test
	public void test_numberOfCircuits2017_Season()
	{
		RestAssured.baseURI = "HOST";
		
		given().
		when().
			get("/api/f1/2017/circuits.json").
		then().
			assertThat().
			statusCode(200).
			and().
			body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
			and().
			header("content-length", equalTo("4551"));
	}

}
