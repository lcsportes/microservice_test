function identifyExtremes(estimates) {
    let lowestEstimate = null
    let highestEstimate = null
    estimates.forEach(function (estimate) {
        if (highestEstimate == null ||
            estimate.score > highestEstimate.score) {
            highestEstimate = estimate
        }
        else if (lowestEstimate == null ||
            estimate.score < lowestEstimate.score) {
            lowestEstimate = estimate
        }
    });
    return [lowestEstimate.person, highestEstimate.person]
}

export { identifyExtremes }
