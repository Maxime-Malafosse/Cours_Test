Scenario: when I create the same champion without the lane it should still find it with the role

Given a new champion Yasuo at top in Toplane
When I create the same Yasuo with only the role top
Then Both champions should have the same lane
......
