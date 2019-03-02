import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { SkuBundle } from 'app/shared/model/sku-bundle.model';
import { SkuBundleService } from './sku-bundle.service';
import { SkuBundleComponent } from './sku-bundle.component';
import { SkuBundleDetailComponent } from './sku-bundle-detail.component';
import { SkuBundleUpdateComponent } from './sku-bundle-update.component';
import { SkuBundleDeletePopupComponent } from './sku-bundle-delete-dialog.component';
import { ISkuBundle } from 'app/shared/model/sku-bundle.model';

@Injectable({ providedIn: 'root' })
export class SkuBundleResolve implements Resolve<ISkuBundle> {
    constructor(private service: SkuBundleService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ISkuBundle> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<SkuBundle>) => response.ok),
                map((skuBundle: HttpResponse<SkuBundle>) => skuBundle.body)
            );
        }
        return of(new SkuBundle());
    }
}

export const skuBundleRoute: Routes = [
    {
        path: '',
        component: SkuBundleComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuBundles'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: SkuBundleDetailComponent,
        resolve: {
            skuBundle: SkuBundleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuBundles'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: SkuBundleUpdateComponent,
        resolve: {
            skuBundle: SkuBundleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuBundles'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: SkuBundleUpdateComponent,
        resolve: {
            skuBundle: SkuBundleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuBundles'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const skuBundlePopupRoute: Routes = [
    {
        path: ':id/delete',
        component: SkuBundleDeletePopupComponent,
        resolve: {
            skuBundle: SkuBundleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuBundles'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
