// ADC 2024
// Day 1 / Part 2 - Answer: 24643097

const inputText = Deno.readTextFileSync("input.txt");
const inputLines = inputText.split("\n");
const leftList: number[] = [];
const rightList: number[] = [];
inputLines.forEach(
    (line) => {
        const [leftValue, rightValue] = line.split("   ");
        leftList.push(parseInt(leftValue, 10));
        rightList.push(parseInt(rightValue, 10));
    },
);
rightList.sort();
let totalSimilarityScore: number = 0;
leftList.forEach(
    (leftNumber) => {
        let count: number = 0;
        for (let i = 0; i < rightList.length; i++) {
            if (rightList[i] === leftNumber) {
                count++;
            } else {
                if (rightList[i] > leftNumber) {
                    break;
                }
            }
        }
        totalSimilarityScore += leftNumber * count;
    },
);
console.log("Total Similarity score:", totalSimilarityScore);
