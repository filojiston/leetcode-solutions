fn num_water_bottles(num_bottles: i32, num_exchange: i32) -> i32 {
    let mut total_bottles = num_bottles;
    let mut empty_bottles = num_bottles;

    while empty_bottles >= num_exchange {
        let exchanged_bottles = empty_bottles / num_exchange;
        total_bottles += exchanged_bottles;
        empty_bottles = empty_bottles % num_exchange + exchanged_bottles;
    }

    total_bottles
}

fn main() {
    let num_bottles = 15;
    let num_exchange = 4;
    let result = num_water_bottles(num_bottles, num_exchange);
    println!("{}", result);
}
