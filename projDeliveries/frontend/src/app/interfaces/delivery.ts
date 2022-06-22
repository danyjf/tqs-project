import { IClient } from "./client";
import { IStore } from "./store";
import { IUser } from "./user";

export interface IDelivery {
    id: number;
    orderTime: string;
    orderId: number;
    store: IStore;
    client: IClient;
    orderNote: string;
    rider: IUser;
    deliveryStatus: string;
    deliveryDelayed: boolean;
}
