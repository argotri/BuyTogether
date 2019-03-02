import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ISkuList } from 'app/shared/model/sku-list.model';

@Component({
    selector: 'jhi-sku-list-detail',
    templateUrl: './sku-list-detail.component.html'
})
export class SkuListDetailComponent implements OnInit {
    skuList: ISkuList;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ skuList }) => {
            this.skuList = skuList;
        });
    }

    previousState() {
        window.history.back();
    }
}
