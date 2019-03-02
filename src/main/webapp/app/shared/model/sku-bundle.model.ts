import { ISkuList } from 'app/shared/model/sku-list.model';

export const enum Source {
    MANUAL_INPUT = 'MANUAL_INPUT',
    SYSTEM_INPUT = 'SYSTEM_INPUT'
}

export interface ISkuBundle {
    id?: number;
    sku?: string;
    score?: number;
    source?: Source;
    skuList?: ISkuList;
}

export class SkuBundle implements ISkuBundle {
    constructor(public id?: number, public sku?: string, public score?: number, public source?: Source, public skuList?: ISkuList) {}
}
