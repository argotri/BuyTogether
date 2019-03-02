import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { SkuList } from 'app/shared/model/sku-list.model';
import { SkuListService } from './sku-list.service';
import { SkuListComponent } from './sku-list.component';
import { SkuListDetailComponent } from './sku-list-detail.component';
import { SkuListUpdateComponent } from './sku-list-update.component';
import { SkuListDeletePopupComponent } from './sku-list-delete-dialog.component';
import { ISkuList } from 'app/shared/model/sku-list.model';

@Injectable({ providedIn: 'root' })
export class SkuListResolve implements Resolve<ISkuList> {
    constructor(private service: SkuListService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ISkuList> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<SkuList>) => response.ok),
                map((skuList: HttpResponse<SkuList>) => skuList.body)
            );
        }
        return of(new SkuList());
    }
}

export const skuListRoute: Routes = [
    {
        path: '',
        component: SkuListComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuLists'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: SkuListDetailComponent,
        resolve: {
            skuList: SkuListResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuLists'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: SkuListUpdateComponent,
        resolve: {
            skuList: SkuListResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuLists'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: SkuListUpdateComponent,
        resolve: {
            skuList: SkuListResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuLists'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const skuListPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: SkuListDeletePopupComponent,
        resolve: {
            skuList: SkuListResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'SkuLists'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
