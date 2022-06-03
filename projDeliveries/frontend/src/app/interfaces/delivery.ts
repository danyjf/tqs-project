export interface IDelivery {
    id: number;
    order_time: string;
    store_name: string;
    store_address: string;
    store_phone: string;
    user_name: string;
    user_address: string;
    user_phone: string;
    order_note: string;
    rider_name: string;
    rider_phone: string;
    delivery_status: string;
    delayed: boolean;
}
