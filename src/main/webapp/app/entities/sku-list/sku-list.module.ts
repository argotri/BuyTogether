import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { BuyTogetherSharedModule } from 'app/shared';
import {
    SkuListComponent,
    SkuListDetailComponent,
    SkuListUpdateComponent,
    SkuListDeletePopupComponent,
    SkuListDeleteDialogComponent,
    skuListRoute,
    skuListPopupRoute
} from './';

const ENTITY_STATES = [...skuListRoute, ...skuListPopupRoute];

@NgModule({
    imports: [BuyTogetherSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        SkuListComponent,
        SkuListDetailComponent,
        SkuListUpdateComponent,
        SkuListDeleteDialogComponent,
        SkuListDeletePopupComponent
    ],
    entryComponents: [SkuListComponent, SkuListUpdateComponent, SkuListDeleteDialogComponent, SkuListDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BuyTogetherSkuListModule {}
