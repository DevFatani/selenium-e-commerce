Feature: User Registration
	I want to check that the user can register in out e-commerce website.
	
	Scenario Outline: User Registration
	Given the user in the home page
	When I click on register link
	And  I entered "<firstname>", "<lastname>", "<email>", "<password>",
	Then The registration page displayed successfully
	

	Examples:
	| firstname | lastname | email | password |
	| ali | zob | ali@zob.com | 3944928248924 |
	| ali23 | zo3234b | al3342i@zob.com | 928248924 |
