import { ISkuList } from 'app/shared/model/sku-list.model';

export const enum Source {
    MANUAL_INPUT = 'MANUAL_INPUT',
    SYSTEM_INPUT = 'SYSTEM_INPUT'
}

export interface ISkuBundle {
    id?: number;
    parentSku?: string;
    score?: number;
    source?: Source;
    parentSkus?: ISkuList[];
}

export class SkuBundle implements ISkuBundle {
    constructor(
        public id?: number,
        public parentSku?: string,
        public score?: number,
        public source?: Source,
        public parentSkus?: ISkuList[]
    ) {}
}
