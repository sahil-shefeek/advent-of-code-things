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
        totalSimilarityScore += rightList.reduce((count, rightNumber) => {
            if (rightNumber === leftNumber) {
                return count + 1;
            } else {
                return count;
            }
        }, 0) * leftNumber;
    },
);
console.log("Total Similarity score:", totalSimilarityScore);
