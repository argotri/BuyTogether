import { ISkuBundle } from 'app/shared/model/sku-bundle.model';

export interface ISkuList {
    id?: number;
    skuCode?: string;
    addedBy?: string;
    skuBundle?: ISkuBundle;
}

export class SkuList implements ISkuList {
    constructor(public id?: number, public skuCode?: string, public addedBy?: string, public skuBundle?: ISkuBundle) {}
}
