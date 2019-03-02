import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BuyTogetherSharedModule } from 'app/shared';
import {
    SkuBundleComponent,
    SkuBundleDetailComponent,
    SkuBundleUpdateComponent,
    SkuBundleDeletePopupComponent,
    SkuBundleDeleteDialogComponent,
    skuBundleRoute,
    skuBundlePopupRoute
} from './';

const ENTITY_STATES = [...skuBundleRoute, ...skuBundlePopupRoute];

@NgModule({
    imports: [BuyTogetherSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        SkuBundleComponent,
        SkuBundleDetailComponent,
        SkuBundleUpdateComponent,
        SkuBundleDeleteDialogComponent,
        SkuBundleDeletePopupComponent
    ],
    entryComponents: [SkuBundleComponent, SkuBundleUpdateComponent, SkuBundleDeleteDialogComponent, SkuBundleDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BuyTogetherSkuBundleModule {}
