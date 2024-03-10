import { expect, test } from 'vitest'
import { identifyExtremes } from "./extremes"


test('identifyExtremes: two elements', () => {
    const estimates = [
        { person: 'P1', score: 20 },
        { person: 'P2', score: 2 },
    ]

    const result = ['P2', 'P1']

    expect(identifyExtremes(estimates)).toStrictEqual(result)
})


test('identifyExtremes: four elements', () => {
    const estimates = [
        { person: 'P1', score: 20 },
        { person: 'P2', score: 4 },
        { person: 'P3', score: 1 },
        { person: 'P4', score: 13 },
    ]

    const result = ['P3', 'P1']

    expect(identifyExtremes(estimates)).toStrictEqual(result)
})

