

// k is an integer that represents the num of ppl in the group
// c is a list of integers that represent the flower prices

// the group will be buying all of the flowers
// each persons first buy of a flower as no upcharge
// however many flowers they have previously bought will be added to 1

const greedyFlorist = (k, c) => {

    // we need to sort the list of integers c in descending order
    c.sort((a, b) => b - a);

    // we need to declare a minCost var initilized to 0
    let minCost = 0;

    // we need to iterate through the list and appropriate caluculate the cost 
    // based on the values in the list
    for( let index = 0; index < c.length; index++) {

        minCost += ( (index / k) + 1) * c[index];
    }

    // we need to return the list

    return minCost;
}

export default greedyFlorist;
