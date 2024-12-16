// ADC 2024
// Day 1 - Answer: 2769675

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
leftList.sort();
rightList.sort();
let totalDistance: number = 0;
for (let i = 0; i < leftList.length; i++) {
    totalDistance += Math.abs(leftList[i] - rightList[i]);
}
console.log("Total distance:", totalDistance);
