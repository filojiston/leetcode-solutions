fn max_bottles_drunk(num_bottles: i32, num_exchange: i32) -> i32 {
    let mut total_bottles = num_bottles;
    let mut empty_bottles = num_bottles;
    let mut num_exchange = num_exchange;

    while empty_bottles >= num_exchange {
        total_bottles += 1;
        empty_bottles = empty_bottles - num_exchange + 1;
        num_exchange += 1;
    }

    total_bottles
}

fn main() {
    let num_bottles = 13;
    let num_exchange = 6;
    let result = max_bottles_drunk(num_bottles, num_exchange);
    println!("{}", result);
}
