import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { ISkuList } from 'app/shared/model/sku-list.model';
import { SkuListService } from './sku-list.service';

@Component({
    selector: 'jhi-sku-list-update',
    templateUrl: './sku-list-update.component.html'
})
export class SkuListUpdateComponent implements OnInit {
    skuList: ISkuList;
    isSaving: boolean;

    constructor(protected skuListService: SkuListService, protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ skuList }) => {
            this.skuList = skuList;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.skuList.id !== undefined) {
            this.subscribeToSaveResponse(this.skuListService.update(this.skuList));
        } else {
            this.subscribeToSaveResponse(this.skuListService.create(this.skuList));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ISkuList>>) {
        result.subscribe((res: HttpResponse<ISkuList>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }
}
