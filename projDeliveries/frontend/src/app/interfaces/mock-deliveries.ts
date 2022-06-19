﻿import { IDelivery } from "./delivery";

export const DELIVERIES: IDelivery[] = [
    // { 
    //     id: 1, 
    //     order_time: "23 MAR 2022 | 12:30",
    //     store_name: "Music",
    //     store_address: "Aveiro, Rua do Viso, nº 4", 
    //     store_phone: "917849583",
    //     user_address: "Aveiro, Urbanização Chave, nº 6", 
    //     user_name: "Pedro", 
    //     user_phone: "934758392", 
    //     order_note: "",
    //     rider_name: "Joana",
    //     rider_phone: "918783745",
    //     delivery_status: "Waiting for rider",
    //     delayed: true
    // },
    // { 
    //     id: 2, 
    //     order_time: "23 MAR 2022 | 12:32",
    //     store_name: "Music",
    //     store_address: "Aveiro, Rua Dr. António Christo, nº 23", 
    //     store_phone: "917849583",
    //     user_address: "Aveiro, Rua Homem Cristo Filho, nº 27", 
    //     user_name: "Daniel", 
    //     user_phone: "918758930", 
    //     order_note: "Toque na campainha e deixe na porta sff",
    //     rider_name: "Miguel",
    //     rider_phone: "938774885",
    //     delivery_status: "Picking up the order",
    //     delayed: false
    // },
    // { 
    //     id: 3, 
    //     order_time: "23 MAR 2022 | 12:48",
    //     store_name: "Food",
    //     store_address: "Aveiro, Rua de Manuel Luiz Nogueira, nº 1", 
    //     store_phone: "917849583",
    //     user_address: "Aveiro, Rua de São Martinho, nº 19", 
    //     user_name: "Nuno", 
    //     user_phone: "918475903", 
    //     order_note: "",
    //     rider_name: "Marta",
    //     rider_phone: "917778889",
    //     delivery_status: "Waiting for rider",
    //     delayed: true
    // },
    // { 
    //     id: 4, 
    //     order_time: "23 MAR 2022 | 13:11",
    //     store_name: "Food",
    //     store_address: "Aveiro, Rua do Batalhão de Caçadores, nº 46", 
    //     store_phone: "917849583",
    //     user_address: "Aveiro, Rua Dr. António Christo, nº 8", 
    //     user_name: "Henrique", 
    //     user_phone: "967495837", 
    //     order_note: "",
    //     rider_name: "Rui",
    //     rider_phone: "966666787",
    //     delivery_status: "Delivering the order",
    //     delayed: true
    // },
    // { 
    //     id: 5, 
    //     order_time: "23 MAR 2022 | 13:53",
    //     store_name: "Music",
    //     store_address: "Aveiro, Rua do Loureiro, nº 22", 
    //     user_address: "Aveiro, Rua de Manuel Luiz Nogueira, nº 12", 
    //     store_phone: "937859746",
    //     user_name: "João", 
    //     user_phone: "934582940", 
    //     order_note: "",
    //     rider_name: "Alcino",
    //     rider_phone: "918888736",
    //     delivery_status: "Waiting for rider",
    //     delayed: false
    // },
    // { 
    //     id: 6, 
    //     order_time: "23 MAR 2022 | 14:24",
    //     store_name: "Music",
    //     store_address: "Aveiro, Rua Homem Cristo Filho, nº 32", 
    //     store_phone: "937859746",
    //     user_address: "Aveiro, Rua de Aires Barbosa, nº 23", 
    //     user_name: "Francisco", 
    //     user_phone: "910847364", 
    //     order_note: "Porta ao lado da loja de costura",
    //     rider_name: "",
    //     rider_phone: "918773849",
    //     delivery_status: "Order delivered",
    //     delayed: false
    // },
    // { 
    //     id: 7, 
    //     order_time: "23 MAR 2022 | 14:42",
    //     store_name: "Medicine",
    //     store_address: "Aveiro, Rua de Passos Manuel, nº 11", 
    //     store_phone: "937859746",
    //     user_address: "Aveiro, Rua do Viso, nº 11", 
    //     user_name: "Susana", 
    //     user_phone: "933748928", 
    //     order_note: "",
    //     rider_name: "Raquel",
    //     rider_phone: "967389209",
    //     delivery_status: "Waiting for rider",
    //     delayed: false
    // },
    // { 
    //     id: 8, 
    //     order_time: "23 MAR 2022 | 15:25",
    //     store_name: "Music",
    //     store_address: "Aveiro, Rua Jaime Moniz, nº 41", 
    //     store_phone: "937859746",
    //     user_address: "Aveiro, Rua Jaime Moniz, nº 22", 
    //     user_name: "Fátima", 
    //     user_phone: "918493058", 
    //     order_note: "",
    //     rider_name: "Alberto",
    //     rider_phone: "936278999",
    //     delivery_status: "Picking up the order",
    //     delayed: true
    // },
    // { 
    //     id: 9, 
    //     order_time: "23 MAR 2022 | 16:31",
    //     store_name: "Medicine",
    //     store_address: "Aveiro, Rua de Aires Barbosa, nº 21", 
    //     store_phone: "967489888",
    //     user_address: "Aveiro, Rua de Passos Manuel, nº 34", 
    //     user_name: "Isabel", 
    //     user_phone: "967840288", 
    //     order_note: "A campainha nao funciona, bata na porta",
    //     rider_name: "Manuel",
    //     rider_phone: "935675267",
    //     delivery_status: "Waiting for rider",
    //     delayed: true
    // },
    // { 
    //     id: 10,
    //     order_time: "23 MAR 2022 | 18:43",
    //     store_name: "Music",
    //     store_address: "Aveiro, Rua de São Martinho, nº 15", 
    //     store_phone: "967489888",
    //     user_address: "Aveiro, Rua do Loureiro, nº 7", 
    //     user_name: "Maria", 
    //     user_phone: "919857777", 
    //     order_note: "Deixar na porta por favor",
    //     rider_name: "Pedro",
    //     rider_phone: "935678466",
    //     delivery_status: "Delivering the order",
    //     delayed: false
    // }
]
