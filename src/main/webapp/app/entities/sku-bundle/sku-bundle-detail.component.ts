import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ISkuBundle } from 'app/shared/model/sku-bundle.model';

@Component({
    selector: 'jhi-sku-bundle-detail',
    templateUrl: './sku-bundle-detail.component.html'
})
export class SkuBundleDetailComponent implements OnInit {
    skuBundle: ISkuBundle;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ skuBundle }) => {
            this.skuBundle = skuBundle;
        });
    }

    previousState() {
        window.history.back();
    }
}
