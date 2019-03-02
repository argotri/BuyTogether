import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'sku-list',
                loadChildren: './sku-list/sku-list.module#BuyTogetherSkuListModule'
            },
            {
                path: 'sku-bundle',
                loadChildren: './sku-bundle/sku-bundle.module#BuyTogetherSkuBundleModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BuyTogetherEntityModule {}
