// heap out of memory :(
function findPoisonedDuration(timeSeries, duration) {
  return new Set(timeSeries.map((time) => Array.from({length: duration}, (_, i) => time + i))
    .flat())
    .size;
}

// time limit exceeded, fuck
function findPoisonedDuration(timeSeries, duration) {
  const result = new Set(); 

  for (const time of timeSeries) {
    const elems = Array.from({length: duration}, (_, i) => time + i);
    elems.forEach(elem => result.add(elem));
  }

  return result.size;
}

// i hate math
function findPoisonedDuration(timeSeries, duration) {
  let totalTime = duration;

  for (let i = 0; i < timeSeries.length - 1; i++) {
    totalTime += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
  }

  return totalTime;
}
