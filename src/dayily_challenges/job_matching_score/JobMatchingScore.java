package dayily_challenges;

/**
 * Created by rijogeorge on 6/26/18.
 */

/*f you didn't know already, there is a very robus US based job platform on this website. We partner with hundreds of top tier tech companies to help our users get discovered and find their dream job by demonstrating their skills. As part of that, we've built a matching engine that identifies which candidates currently looking for a job are a good match for which jobs from our partner companies. The matching engine takes a lot of attributes into account, but location is one of the trickier ones. Your challenge is to build a highly simplified version of the matching engine limiting the scope to location matching only.

You're given a list of candidate locations in the following form "city, state, country", for example:

San Francisco, California, United States
..., ..., ...
..., ..., ...
Return the number of candidates matching the given job location criteria. The criteria can have one of the following 3 forms:

San Francisco, California, United States - candidates from the given city
California, United States - candidates from the given state
United States - candidates from the given country
Note that there can be multiple cities with the same name in different states, and there can be multiple states with the same name in different countries.

Example

For
locations = ["San Francisco, California, United States",
             "San Mateo, California, United States",
             "Columbia, South Carolina, United States",
             "Columbia, California, United States"]
and criteria = "United States", the output should be jobMatchingScore(locations, criteria) = 4.

All candidate locations match the given criteria (country only).

For
locations = ["San Francisco, California, United States",
             "San Mateo, California, United States",
             "Columbia, South Carolina, United States",
             "Columbia, California, United States"]
and criteria = "Columbia, South Carolina, United States", the output should be jobMatchingScore(locations, criteria) = 1.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.string locations

A list of candidate locations. It is guaranteed that location names doesn't contain commas.

Guaranteed constraints:
1 ≤ locations.length ≤ 104,
7 ≤ locations[i].length ≤ 100.

[input] string criteria

The given job location criteria. It is guaranteed that this criteria follows one of the forms mentioned in the description.

Guaranteed constraints:
1 ≤ criteria.length ≤ 100.

[output] integer

The number of candidate locations that match the given criteria.*/

public class JobMatchingScore {

    int jobMatchingScore(String[] locations, String criteria) {
        String[] splits = criteria.split(",", 3);
        String[] criterias = reverseArray(splits);
        int count = 0;
        for(int i=0; i<locations.length; i++) {
            if(isLocationMatchesCriteria(locations[i], criterias))
                count++;
        }
        return count;
    }

    private boolean isLocationMatchesCriteria(String location, String[] criterias) {
        String[] locationsArray = location.split(",",3);
        boolean cityMatch = criterias.length<3 || criterias[2].equals(locationsArray[0]) ? true : false;
        boolean stateMatch = criterias.length<2 || criterias[1].trim().equals(locationsArray[1].trim()) ? true : false;
        boolean countryMatch = criterias[0].trim().equals(locationsArray[2].trim()) ? true : false;
        if(cityMatch && stateMatch && countryMatch)
            return true;
        return false;
    }

    private String[] reverseArray(String[] splits) {
        String[] criterias = new String[splits.length];
        for(int i=criterias.length-1; i>=0; i--)
            criterias[criterias.length-(i+1)] = splits[i];
        return criterias;
    }

}
