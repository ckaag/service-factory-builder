package com.github.ckaag.liferay.service.factory.builder

import com.github.ckaag.liferay.service.factory.builder.mock.Dependencies

/**
 * Created by usickaag on Freitag, 24.07.2020 at 13:22.
 */



val exampleServiceXml = """<?xml version="1.0"?>
<!DOCTYPE service-builder PUBLIC "-//Liferay//DTD Service Builder 7.2.0//EN" "http://www.liferay.com/dtd/liferay-service-builder_7_2_0.dtd">

<service-builder dependency-injector="ds" package-path="com.usu.moe.inside.bistro">
	<namespace>USUBISTRO</namespace>

	<entity local-service="false" name="BistroDish" remote-service="false" uuid="false">
		<column name="dishId" primary="true" type="long" />
		<column name="label" type="String" />
		<column name="imageUrl" type="String" />
		<column name="dateOfServing" type="Date" />

		<column name="createdDate" type="Date" />
		<column name="modifiedDate" type="Date" />
		<column name="userId" type="long" />
		<column name="groupId" type="long" />
		<column name="status" type="int" />
	</entity>
	<entity local-service="false" name="BistroPreOrder" remote-service="false" uuid="false">
		<column name="preOrderId" primary="true" type="long" />
		<column name="dishId" type="long" />
		<column name="employeeId" type="long" />
		<column name="timestamp" type="Date" />
	</entity>
	<entity local-service="false" name="BistroDishOrder" remote-service="false" uuid="false">
		<column name="orderId" primary="true" type="long" />
		<column name="dishId" type="long" />
		<column name="employeeId" type="long" />
		<column name="centsPriceAtPurchase" type="int" />
		<column name="timestamp" type="Date" />
	</entity>
	<entity local-service="false" name="BistroItem" remote-service="false" uuid="false">
		<column name="itemId" primary="true" type="long" />
		<column name="label" type="String" />
		<column name="imageUrl" type="String" />
		<column name="groupId" type="long" />
		<column name="categories" type="Collection" mapping-table="Orders_Cats" entity="BistroItemCategory" />
		
		<column name="createdDate" type="Date" />
		<column name="modifiedDate" type="Date" />
		<column name="userId" type="long" />
		<column name="status" type="int" />
	</entity>
	<entity local-service="false" name="BistroItemCategory" remote-service="false" uuid="false">
		<column name="categoryId" primary="true" type="long" />
		<column name="order" type="int" />
		<column name="label" type="String" />
		<column name="items" type="Collection" mapping-table="Orders_Cats" entity="BistroItem" />
		
		<column name="createdDate" type="Date" />
		<column name="modifiedDate" type="Date" />
		<column name="userId" type="long" />
		<column name="groupId" type="long" />
		<column name="status" type="int" />
	</entity>
	<entity local-service="false" name="BistroItemOrder" remote-service="false" uuid="false">
		<column name="orderId" primary="true" type="long" />
		<column name="itemId" type="long" />
		<column name="employeeId" type="long" />
		<column name="centsPriceAtPurchase" type="int" />
		<column name="timestamp" type="Date" />
	</entity>
	<entity local-service="false" name="BistroCatering" remote-service="false" uuid="false">
		<column name="orderId" primary="true" type="long" />
		<column name="employeeId" type="long" />
		<column name="start" type="Date" />
		<column name="durationMinutes" type="int" />
		<column name="costCenter" type="String" />
		<column name="cateringLocation" type="String" />

		<column name="cateringOrderJson" type="String" /> <!-- {"<name1>" : 13, "<name2" : 42, "coffee" : 0} -->
		<column name="internalGuests" type="int" />
		<column name="externalGuests" type="int" />
		<column name="comments" type="String" />

		<column name="createdDate" type="Date" />
		<column name="modifiedDate" type="Date" />
		<column name="userId" type="long" />
		<column name="groupId" type="long" />
		<column name="status" type="int" />
		
	</entity>
	
	
	<!-- INSTEAD USE OSGI CONFIGURATIONS FOR THE FOLLOWING ENTRIES (because values are semi-static): 
	<entity local-service="false" name="BistroCostCenter" remote-service="false" uuid="false">
		
	</entity>
	<entity local-service="false" name="BistroCateringLocation" remote-service="false" uuid="false">
		
	</entity>
	-->
	
</service-builder>
"""

val simpleTypedXml = """<?xml version="1.0"?>
<!DOCTYPE service-builder PUBLIC "-//Liferay//DTD Service Builder 7.2.0//EN" "http://www.liferay.com/dtd/liferay-service-builder_7_2_0.dtd">

<service-builder dependency-injector="ds" package-path="com.usu.moe.inside.bistro">
	<namespace>USUBISTRO</namespace>

	<entity local-service="false" name="BistroDish" remote-service="false" uuid="false">
		<column name="dishId" primary="true" type="long" />
		<column name="label" type="String" />
		<column name="imageUrl" type="String" />
		<column name="dateOfServing" type="Date" />

		<column name="createdDate" type="Date" />
		<column name="modifiedDate" type="Date" />
		<column name="userId" type="long" />
		<column name="groupId" type="long" />
		<column name="status" type="int" />
	</entity>
</service-builder>
"""

val simpleTypedXmlHints = """<?xml version="1.0"?>

<model-hints>
	<model name="com.usu.moe.inside.bistro.model.BistroDish">
		<field name="dishId" type="long" />
		<field name="label" type="String"  >
			<validator name="required"/>
		</field>
		<field name="imageUrl" type="String" />
		<field name="dateOfServing" type="Date"  >
			<validator name="required"/>
		</field>
		<field name="createdDate" type="Date"  >
			<validator name="required"/>
		</field>
		<field name="modifiedDate" type="Date" />
		<field name="userId" type="long"  >
			<validator name="required"/>
		</field>
		<field name="groupId" type="long" />
		<field name="status" type="int" />
	</model>
</model-hints>
    
"""

