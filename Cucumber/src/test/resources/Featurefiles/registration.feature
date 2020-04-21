 Feature: Validating Registration Functionality

 Scenario Outline:
 Given	I	am	on	axone-tech.co.uk registration	page
 When	I	enter	<username>
 When	I	enter	<password>
 When	I	enter	<mobile-number>
 Then	registration	should	be	<result>

  Examples:
  |username|password|mobile-number|result|
